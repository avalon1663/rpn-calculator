package org.coding.exercise.common;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OperationLogTest {

    @Test
    public void withPushed() {
        OperationLog
                operationLog = new OperationLog();
        Assert.assertTrue(operationLog.getPushed().isEmpty());

        operationLog.withPushed(1D);
        Assert.assertArrayEquals(new Object[]{1D}, operationLog.getPushed().toArray());
    }

    @Test
    public void withOrderPopped() {
        OperationLog
                operationLog = new OperationLog();
        Assert.assertTrue(operationLog.getPushed().isEmpty());

        operationLog.withOrderPopped(1D, 3D, 5D);
        Assert.assertArrayEquals(new Object[]{1D, 3D, 5D}, operationLog.getPopped().toArray());
    }
}