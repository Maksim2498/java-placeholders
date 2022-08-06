package space.moontalk.placeholders;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface Substituter {
    @NonNull String substitute(@NonNull String target, @NonNull String ...replacements);  
    @NonNull DelimitersPair getDelimitersPair();
    void setDelimitersPair(@NonNull DelimitersPair pair);
}
