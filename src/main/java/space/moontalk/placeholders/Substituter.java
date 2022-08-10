package space.moontalk.placeholders;

import org.jetbrains.annotations.NotNull;

public interface Substituter {
    @NotNull String substitute(@NotNull String target, @NotNull String ...replacements);  
    @NotNull DelimitersPair getDelimitersPair();
    void setDelimitersPair(@NotNull DelimitersPair pair);
}
