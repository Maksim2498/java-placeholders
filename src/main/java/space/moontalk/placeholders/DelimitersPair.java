package space.moontalk.placeholders;

import org.checkerframework.checker.nullness.qual.NonNull;

import lombok.Value;

@Value
public class DelimitersPair {
    public static final DelimitersPair ANGLE        = new DelimitersPair("<", ">");
    public static final DelimitersPair CURLY        = new DelimitersPair("{", "}");
    public static final DelimitersPair DOLLAR_CURLY = new DelimitersPair("${", "}");

    private final @NonNull String open;
    private final @NonNull String close;
}
