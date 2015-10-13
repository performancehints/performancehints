/*
 * package-info.java
 * Written by Gil Tene of Azul Systems, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */

/**
 * <h3>org.performancehints</h3>
 * <p>
 * org.performancehints is a java library that includes some performance hint
 * API calls that may be optimized on certain versions of Java SE, but may not
 * be optimized in others. Using org.performancehints allows Java code
 * that wishes to make use of hint APIs available in newer JDKs to operate
 * across multiple versions of Java SE without needing separate libraries or
 * code for each. Since all API calls in this package are hints (and hence
 * have a valid nop implementation), the implementation on older Java versions
 * will be a nop, while the implementation on newer JDKs will use their
 * newer hint capabilities.
 * </p>
 */

package org.performancehints;


