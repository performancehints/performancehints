#org.performancehints

org.performancehints is a java library that includes some performance hint
API calls that may be optimized on certain versions of Java SE, but may not
be optimized in others. Using org.performancehints allows Java code
that wishes to make use of hint APIs available in newer JDKs to operate
across multiple versions of Java SE without needing separate libraries or
code for each. Since all API calls in this package are hints (and hence
have a valid nop implementation), the implementation on older Java versions
will be a nop, while the implementation on newer JDKs will use their
newer hint capabilities.

Currently, org.performancehints contains a single hint method: spinLoopHint()
in anticipation of a future Java SE version (e.g. Java SE 9) supporting
that capability (e.g. as Thread.spinLoopHint()).
