package com.wx.springinaction.aspect;

import com.wx.springinaction.service.Encoreable;
import com.wx.springinaction.service.imp.EncoreableImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * User: Mr.Wang
 * Date: 2020/2/8
 */
@Aspect
public class EncoreableIntrodeucer {
    @DeclareParents(value = "com.wx.springinaction.service.Performance+", defaultImpl = EncoreableImpl.class)
    private static Encoreable encoreable;
}
