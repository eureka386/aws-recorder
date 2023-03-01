package org.example;

import software.amazon.awssdk.core.interceptor.Context;
import software.amazon.awssdk.core.interceptor.ExecutionAttribute;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;

import java.util.Map;
import java.util.UUID;


public class AwsSdkInterceptor implements ExecutionInterceptor {
    private UUID uuid = UUID.randomUUID();

    public void beforeExecution(Context.BeforeExecution context, ExecutionAttributes executionAttributes) {
        try {
            System.out.println("AwsSdkInterceptor.beforeExecution");
            System.out.println(uuid);
            Map<ExecutionAttribute<?>, Object> beforeAttributes = executionAttributes.getAttributes();
            for (ExecutionAttribute<?> executionAttribute : beforeAttributes.keySet()) {
                String attrName = executionAttribute.toString();
                Object attributeVal = executionAttributes.getAttribute(executionAttribute);
                System.out.println("beforeAttr|" + attrName + "=" + attributeVal);
            }
            throw new RuntimeException("고의로 발생시킨 에러입니다.");
        } catch (Exception e) {
            System.out.println("AwsSdkInterceptor.beforeExecution:" + e);
        }
    }

    public void afterTransmission(Context.AfterTransmission context, ExecutionAttributes executionAttributes) {
        try {
            System.out.println("AwsSdkInterceptor.afterTransmission");
            System.out.println(uuid);
            Map<ExecutionAttribute<?>, Object> beforeAttributes = executionAttributes.getAttributes();
            for (ExecutionAttribute<?> executionAttribute : beforeAttributes.keySet()) {
                String attrName = executionAttribute.toString();
                Object attributeVal = executionAttributes.getAttribute(executionAttribute);
                System.out.println("afterTransmission|" + attrName + "=" + attributeVal);
            }
            throw new RuntimeException("고의로 발생시킨 에러입니다.");
        } catch (Exception e) {
            System.out.println("AwsSdkInterceptor.afterTransmission:" + e);
        }
    }

    public void afterExecution(Context.AfterExecution context, ExecutionAttributes executionAttributes) {
        try {
            System.out.println("AwsSdkInterceptor.afterExecution");
            System.out.println(uuid);
            Map<ExecutionAttribute<?>, Object> afterAttributes = executionAttributes.getAttributes();
            for (ExecutionAttribute<?> executionAttribute : afterAttributes.keySet()) {
                String attrName = executionAttribute.toString();
                Object attributeVal = executionAttributes.getAttribute(executionAttribute);
                System.out.println("afterExecution|" + attrName + "=" + attributeVal);
            }
            throw new RuntimeException("고의로 발생시킨 에러입니다.");
        } catch (Exception e) {
            System.out.println("AwsSdkInterceptor.afterExecution:" + e);
        }
    }
}

