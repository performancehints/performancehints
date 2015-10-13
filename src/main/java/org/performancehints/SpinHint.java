/**
 * Written by Gil Tene of Azul Systems, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 *
 * @author Gil Tene
 */

package org.performancehints;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public final class SpinHint {

    private static final MethodHandle spinLoopHintMH;

    static {
        MethodHandle mh;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            mh = lookup.findStatic(Thread.class, "spinLoop", MethodType.methodType(void.class));
        } catch (Exception e) {
            mh = null;
        }
        spinLoopHintMH = mh;
    }

    // prevent construction...
    private SpinHint() {
    }

    /**
     * Provide the JVM with a hint that this call is made from within a spinning
     * loop. The JVM may assume that the speed of executing the loop (e.g. in
     * terms of number of loop executions per second) is less important than the
     * reaction time to events that would cause the loop to terminate, or than
     * potential power savings that may be derived from possible execution
     * choices. The JVM will not slow down the loop execution to a point where
     * execution will be delayed indefinitely, but other choices of loop execution
     * speed are system-specific. Note that a nop is a valid implementation of
     * this hint.
     */
    public static void spinLoopHint() {
        // Call Thread.spinLoopHint() on Java SE versions that support it. Do nothing otherwise.
        if (spinLoopHintMH != null) {
            try {
                spinLoopHintMH.invokeExact();
            } catch (Throwable throwable) {
                // Nothing to do here...
            }
        }
    }

}