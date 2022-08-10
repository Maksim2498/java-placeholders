package space.moontalk.placeholders;

import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@AllArgsConstructor
public class DefaultSubstituter implements Substituter {
    @NotNull
    @Getter
    @Setter
    private DelimitersPair delimitersPair;

    public DefaultSubstituter() {
        delimitersPair = DelimitersPair.ANGLE;
    }

    @Override
    public @NotNull String substitute(@NotNull String target, @NotNull String ...replacements) {
        if (replacements.length % 2 != 0)
            throw new IllegalArgumentException("number of replacements has to be even");

       val builder = new StringBuilder();

        val open  = delimitersPair.getOpen();
        val close = delimitersPair.getClose();

        int i = 0; 

        while (i < target.length()) {
            val openIndex = target.indexOf(open, i);            

            if (openIndex == -1)
                break;

            val valueIndex = openIndex + open.length();
            val closeIndex = target.indexOf(close, valueIndex);

            if (closeIndex == -1)
                break;

            val rawValue = target.substring(valueIndex, closeIndex);
            val value    = substitutedOrNull(rawValue, replacements);

            if (value == null) {
                builder.append(target.charAt(i++));
                continue;
            }

            builder.append(target.substring(i, openIndex));
            builder.append(value);

            val endIndex = closeIndex + close.length();

            i = endIndex;
        }

        val rest = target.substring(i);

        builder.append(rest);

        return builder.toString();
    }

    private static @NotNull String substitutedOrNull(@NotNull String value, @NotNull String[] replacements) {
        for (int i = 0; i < replacements.length; i += 2) 
            if (value.equals(replacements[i]))
                return replacements[i + 1];

        return null;
    }
}
