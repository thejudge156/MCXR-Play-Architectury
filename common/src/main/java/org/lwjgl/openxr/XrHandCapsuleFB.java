/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.openxr;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

import java.nio.ByteBuffer;

import static org.lwjgl.openxr.FBHandTrackingCapsules.XR_FB_HAND_TRACKING_CAPSULE_POINT_COUNT;
import static org.lwjgl.system.Checks.check;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.system.MemoryUtil.memAddress;

/**
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct XrHandCapsuleFB {
 *     {@link XrVector3f XrVector3f} points[XR_FB_HAND_TRACKING_CAPSULE_POINT_COUNT];
 *     float radius;
 *     XrHandJointEXT joint;
 * }</code></pre>
 */
public class XrHandCapsuleFB extends Struct {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        POINTS,
        RADIUS,
        JOINT;

    static {
        Layout layout = __struct(
            __array(XrVector3f.SIZEOF, XrVector3f.ALIGNOF, XR_FB_HAND_TRACKING_CAPSULE_POINT_COUNT),
            __member(4),
            __member(4)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        POINTS = layout.offsetof(0);
        RADIUS = layout.offsetof(1);
        JOINT = layout.offsetof(2);
    }

    /**
     * Creates a {@code XrHandCapsuleFB} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public XrHandCapsuleFB(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return a {@link XrVector3f}.Buffer view of the {@code points} field. */
    @NativeType("XrVector3f[XR_FB_HAND_TRACKING_CAPSULE_POINT_COUNT]")
    public XrVector3f.Buffer points() { return npoints(address()); }
    /** @return a {@link XrVector3f} view of the struct at the specified index of the {@code points} field. */
    public XrVector3f points(int index) { return npoints(address(), index); }
    /** @return the value of the {@code radius} field. */
    public float radius() { return nradius(address()); }
    /** @return the value of the {@code joint} field. */
    @NativeType("XrHandJointEXT")
    public int joint() { return njoint(address()); }

    // -----------------------------------

    /** Returns a new {@code XrHandCapsuleFB} instance for the specified memory address. */
    public static XrHandCapsuleFB create(long address) {
        return wrap(XrHandCapsuleFB.class, address);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static XrHandCapsuleFB createSafe(long address) {
        return address == NULL ? null : wrap(XrHandCapsuleFB.class, address);
    }

    /**
     * Create a {@link Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static Buffer create(long address, int capacity) {
        return wrap(Buffer.class, address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static XrHandCapsuleFB.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : wrap(Buffer.class, address, capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #points}. */
    public static XrVector3f.Buffer npoints(long struct) { return XrVector3f.create(struct + XrHandCapsuleFB.POINTS, XR_FB_HAND_TRACKING_CAPSULE_POINT_COUNT); }
    /** Unsafe version of {@link #points(int) points}. */
    public static XrVector3f npoints(long struct, int index) {
        return XrVector3f.create(struct + XrHandCapsuleFB.POINTS + check(index, XR_FB_HAND_TRACKING_CAPSULE_POINT_COUNT) * XrVector3f.SIZEOF);
    }
    /** Unsafe version of {@link #radius}. */
    public static float nradius(long struct) { return UNSAFE.getFloat(null, struct + XrHandCapsuleFB.RADIUS); }
    /** Unsafe version of {@link #joint}. */
    public static int njoint(long struct) { return UNSAFE.getInt(null, struct + XrHandCapsuleFB.JOINT); }

    // -----------------------------------

    /** An array of {@link XrHandCapsuleFB} structs. */
    public static class Buffer extends StructBuffer<XrHandCapsuleFB, Buffer> {

        private static final XrHandCapsuleFB ELEMENT_FACTORY = XrHandCapsuleFB.create(-1L);

        /**
         * Creates a new {@code XrHandCapsuleFB.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link XrHandCapsuleFB#SIZEOF}, and its mark will be undefined.
         *
         * <p>The created buffer instance holds a strong reference to the container object.</p>
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected XrHandCapsuleFB getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return a {@link XrVector3f}.Buffer view of the {@code points} field. */
        @NativeType("XrVector3f[XR_FB_HAND_TRACKING_CAPSULE_POINT_COUNT]")
        public XrVector3f.Buffer points() { return XrHandCapsuleFB.npoints(address()); }
        /** @return a {@link XrVector3f} view of the struct at the specified index of the {@code points} field. */
        public XrVector3f points(int index) { return XrHandCapsuleFB.npoints(address(), index); }
        /** @return the value of the {@code radius} field. */
        public float radius() { return XrHandCapsuleFB.nradius(address()); }
        /** @return the value of the {@code joint} field. */
        @NativeType("XrHandJointEXT")
        public int joint() { return XrHandCapsuleFB.njoint(address()); }

    }

}