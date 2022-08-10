package space.moontalk.placeholders;

import org.jetbrains.annotations.NotNull;

import lombok.Value;

@Value
public class DelimitersPair {
    public static final DelimitersPair ANGLE        = new DelimitersPair("<", ">");
    public static final DelimitersPair CURLY        = new DelimitersPair("{", "}");
    public static final DelimitersPair DOLLAR_CURLY = new DelimitersPair("${", "}");

    private final @NotNull String open;
    private final @NotNull String close;
}
