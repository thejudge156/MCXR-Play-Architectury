/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.openxr;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.*;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.*;

/**
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct XrColor4f {
 *     float r;
 *     float g;
 *     float b;
 *     float a;
 * }</code></pre>
 */
public class XrColor4f extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        R,
        G,
        B,
        A;

    static {
        Layout layout = __struct(
            __member(4),
            __member(4),
            __member(4),
            __member(4)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        R = layout.offsetof(0);
        G = layout.offsetof(1);
        B = layout.offsetof(2);
        A = layout.offsetof(3);
    }

    /**
     * Creates a {@code XrColor4f} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public XrColor4f(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code r} field. */
    public float r() { return nr(address()); }
    /** @return the value of the {@code g} field. */
    public float g() { return ng(address()); }
    /** @return the value of the {@code b} field. */
    public float b() { return nb(address()); }
    /** @return the value of the {@code a} field. */
    public float a() { return na(address()); }

    /** Sets the specified value to the {@code r} field. */
    public XrColor4f r(float value) { nr(address(), value); return this; }
    /** Sets the specified value to the {@code g} field. */
    public XrColor4f g(float value) { ng(address(), value); return this; }
    /** Sets the specified value to the {@code b} field. */
    public XrColor4f b(float value) { nb(address(), value); return this; }
    /** Sets the specified value to the {@code a} field. */
    public XrColor4f a(float value) { na(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public XrColor4f set(
        float r,
        float g,
        float b,
        float a
    ) {
        r(r);
        g(g);
        b(b);
        a(a);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public XrColor4f set(XrColor4f src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code XrColor4f} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static XrColor4f malloc() {
        return wrap(XrColor4f.class, nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@code XrColor4f} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static XrColor4f calloc() {
        return wrap(XrColor4f.class, nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@code XrColor4f} instance allocated with {@link BufferUtils}. */
    public static XrColor4f create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return wrap(XrColor4f.class, memAddress(container), container);
    }

    /** Returns a new {@code XrColor4f} instance for the specified memory address. */
    public static XrColor4f create(long address) {
        return wrap(XrColor4f.class, address);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static XrColor4f createSafe(long address) {
        return address == NULL ? null : wrap(XrColor4f.class, address);
    }

    /**
     * Returns a new {@link Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static Buffer malloc(int capacity) {
        return wrap(Buffer.class, nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static Buffer calloc(int capacity) {
        return wrap(Buffer.class, nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return wrap(Buffer.class, memAddress(container), capacity, container);
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
    public static XrColor4f.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : wrap(Buffer.class, address, capacity);
    }


    /**
     * Returns a new {@code XrColor4f} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static XrColor4f malloc(MemoryStack stack) {
        return wrap(XrColor4f.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@code XrColor4f} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static XrColor4f calloc(MemoryStack stack) {
        return wrap(XrColor4f.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    /**
     * Returns a new {@link Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static Buffer malloc(int capacity, MemoryStack stack) {
        return wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static Buffer calloc(int capacity, MemoryStack stack) {
        return wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #r}. */
    public static float nr(long struct) { return UNSAFE.getFloat(null, struct + XrColor4f.R); }
    /** Unsafe version of {@link #g}. */
    public static float ng(long struct) { return UNSAFE.getFloat(null, struct + XrColor4f.G); }
    /** Unsafe version of {@link #b}. */
    public static float nb(long struct) { return UNSAFE.getFloat(null, struct + XrColor4f.B); }
    /** Unsafe version of {@link #a}. */
    public static float na(long struct) { return UNSAFE.getFloat(null, struct + XrColor4f.A); }

    /** Unsafe version of {@link #r(float) r}. */
    public static void nr(long struct, float value) { UNSAFE.putFloat(null, struct + XrColor4f.R, value); }
    /** Unsafe version of {@link #g(float) g}. */
    public static void ng(long struct, float value) { UNSAFE.putFloat(null, struct + XrColor4f.G, value); }
    /** Unsafe version of {@link #b(float) b}. */
    public static void nb(long struct, float value) { UNSAFE.putFloat(null, struct + XrColor4f.B, value); }
    /** Unsafe version of {@link #a(float) a}. */
    public static void na(long struct, float value) { UNSAFE.putFloat(null, struct + XrColor4f.A, value); }

    // -----------------------------------

    /** An array of {@link XrColor4f} structs. */
    public static class Buffer extends StructBuffer<XrColor4f, Buffer> implements NativeResource {

        private static final XrColor4f ELEMENT_FACTORY = XrColor4f.create(-1L);

        /**
         * Creates a new {@code XrColor4f.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link XrColor4f#SIZEOF}, and its mark will be undefined.
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
        protected XrColor4f getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code r} field. */
        public float r() { return XrColor4f.nr(address()); }
        /** @return the value of the {@code g} field. */
        public float g() { return XrColor4f.ng(address()); }
        /** @return the value of the {@code b} field. */
        public float b() { return XrColor4f.nb(address()); }
        /** @return the value of the {@code a} field. */
        public float a() { return XrColor4f.na(address()); }

        /** Sets the specified value to the {@code r} field. */
        public Buffer r(float value) { XrColor4f.nr(address(), value); return this; }
        /** Sets the specified value to the {@code g} field. */
        public Buffer g(float value) { XrColor4f.ng(address(), value); return this; }
        /** Sets the specified value to the {@code b} field. */
        public Buffer b(float value) { XrColor4f.nb(address(), value); return this; }
        /** Sets the specified value to the {@code a} field. */
        public Buffer a(float value) { XrColor4f.na(address(), value); return this; }

    }

}