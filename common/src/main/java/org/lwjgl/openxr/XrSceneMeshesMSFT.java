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
 * struct XrSceneMeshesMSFT {
 *     XrStructureType type;
 *     void * next;
 *     uint32_t sceneMeshCount;
 *     {@link XrSceneMeshMSFT XrSceneMeshMSFT} * sceneMeshes;
 * }</code></pre>
 */
public class XrSceneMeshesMSFT extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        TYPE,
        NEXT,
        SCENEMESHCOUNT,
        SCENEMESHES;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(4),
            __member(POINTER_SIZE)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        TYPE = layout.offsetof(0);
        NEXT = layout.offsetof(1);
        SCENEMESHCOUNT = layout.offsetof(2);
        SCENEMESHES = layout.offsetof(3);
    }

    /**
     * Creates a {@code XrSceneMeshesMSFT} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public XrSceneMeshesMSFT(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code type} field. */
    @NativeType("XrStructureType")
    public int type() { return ntype(address()); }
    /** @return the value of the {@code next} field. */
    @NativeType("void *")
    public long next() { return nnext(address()); }
    /** @return the value of the {@code sceneMeshCount} field. */
    @NativeType("uint32_t")
    public int sceneMeshCount() { return nsceneMeshCount(address()); }
    /** @return a {@link XrSceneMeshMSFT.Buffer} view of the struct array pointed to by the {@code sceneMeshes} field. */
    @Nullable
    @NativeType("XrSceneMeshMSFT *")
    public XrSceneMeshMSFT.Buffer sceneMeshes() { return nsceneMeshes(address()); }

    /** Sets the specified value to the {@code type} field. */
    public XrSceneMeshesMSFT type(@NativeType("XrStructureType") int value) { ntype(address(), value); return this; }
    /** Sets the {@link MSFTSceneUnderstanding#XR_TYPE_SCENE_MESHES_MSFT TYPE_SCENE_MESHES_MSFT} value to the {@code type} field. */
    public XrSceneMeshesMSFT type$Default() { return type(MSFTSceneUnderstanding.XR_TYPE_SCENE_MESHES_MSFT); }
    /** Sets the specified value to the {@code next} field. */
    public XrSceneMeshesMSFT next(@NativeType("void *") long value) { nnext(address(), value); return this; }
    /** Sets the specified value to the {@code sceneMeshCount} field. */
    public XrSceneMeshesMSFT sceneMeshCount(@NativeType("uint32_t") int value) { nsceneMeshCount(address(), value); return this; }
    /** Sets the address of the specified {@link XrSceneMeshMSFT.Buffer} to the {@code sceneMeshes} field. */
    public XrSceneMeshesMSFT sceneMeshes(@Nullable @NativeType("XrSceneMeshMSFT *") XrSceneMeshMSFT.Buffer value) { nsceneMeshes(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public XrSceneMeshesMSFT set(
        int type,
        long next,
        int sceneMeshCount,
        @Nullable XrSceneMeshMSFT.Buffer sceneMeshes
    ) {
        type(type);
        next(next);
        sceneMeshCount(sceneMeshCount);
        sceneMeshes(sceneMeshes);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public XrSceneMeshesMSFT set(XrSceneMeshesMSFT src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code XrSceneMeshesMSFT} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static XrSceneMeshesMSFT malloc() {
        return wrap(XrSceneMeshesMSFT.class, nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@code XrSceneMeshesMSFT} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static XrSceneMeshesMSFT calloc() {
        return wrap(XrSceneMeshesMSFT.class, nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@code XrSceneMeshesMSFT} instance allocated with {@link BufferUtils}. */
    public static XrSceneMeshesMSFT create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return wrap(XrSceneMeshesMSFT.class, memAddress(container), container);
    }

    /** Returns a new {@code XrSceneMeshesMSFT} instance for the specified memory address. */
    public static XrSceneMeshesMSFT create(long address) {
        return wrap(XrSceneMeshesMSFT.class, address);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static XrSceneMeshesMSFT createSafe(long address) {
        return address == NULL ? null : wrap(XrSceneMeshesMSFT.class, address);
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
    public static XrSceneMeshesMSFT.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : wrap(Buffer.class, address, capacity);
    }


    /**
     * Returns a new {@code XrSceneMeshesMSFT} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static XrSceneMeshesMSFT malloc(MemoryStack stack) {
        return wrap(XrSceneMeshesMSFT.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@code XrSceneMeshesMSFT} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static XrSceneMeshesMSFT calloc(MemoryStack stack) {
        return wrap(XrSceneMeshesMSFT.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
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

    /** Unsafe version of {@link #type}. */
    public static int ntype(long struct) { return UNSAFE.getInt(null, struct + XrSceneMeshesMSFT.TYPE); }
    /** Unsafe version of {@link #next}. */
    public static long nnext(long struct) { return memGetAddress(struct + XrSceneMeshesMSFT.NEXT); }
    /** Unsafe version of {@link #sceneMeshCount}. */
    public static int nsceneMeshCount(long struct) { return UNSAFE.getInt(null, struct + XrSceneMeshesMSFT.SCENEMESHCOUNT); }
    /** Unsafe version of {@link #sceneMeshes}. */
    @Nullable public static XrSceneMeshMSFT.Buffer nsceneMeshes(long struct) { return XrSceneMeshMSFT.createSafe(memGetAddress(struct + XrSceneMeshesMSFT.SCENEMESHES), nsceneMeshCount(struct)); }

    /** Unsafe version of {@link #type(int) type}. */
    public static void ntype(long struct, int value) { UNSAFE.putInt(null, struct + XrSceneMeshesMSFT.TYPE, value); }
    /** Unsafe version of {@link #next(long) next}. */
    public static void nnext(long struct, long value) { memPutAddress(struct + XrSceneMeshesMSFT.NEXT, value); }
    /** Sets the specified value to the {@code sceneMeshCount} field of the specified {@code struct}. */
    public static void nsceneMeshCount(long struct, int value) { UNSAFE.putInt(null, struct + XrSceneMeshesMSFT.SCENEMESHCOUNT, value); }
    /** Unsafe version of {@link #sceneMeshes(XrSceneMeshMSFT.Buffer) sceneMeshes}. */
    public static void nsceneMeshes(long struct, @Nullable XrSceneMeshMSFT.Buffer value) { memPutAddress(struct + XrSceneMeshesMSFT.SCENEMESHES, memAddressSafe(value)); if (value != null) { nsceneMeshCount(struct, value.remaining()); } }

    // -----------------------------------

    /** An array of {@link XrSceneMeshesMSFT} structs. */
    public static class Buffer extends StructBuffer<XrSceneMeshesMSFT, Buffer> implements NativeResource {

        private static final XrSceneMeshesMSFT ELEMENT_FACTORY = XrSceneMeshesMSFT.create(-1L);

        /**
         * Creates a new {@code XrSceneMeshesMSFT.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link XrSceneMeshesMSFT#SIZEOF}, and its mark will be undefined.
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
        protected XrSceneMeshesMSFT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code type} field. */
        @NativeType("XrStructureType")
        public int type() { return XrSceneMeshesMSFT.ntype(address()); }
        /** @return the value of the {@code next} field. */
        @NativeType("void *")
        public long next() { return XrSceneMeshesMSFT.nnext(address()); }
        /** @return the value of the {@code sceneMeshCount} field. */
        @NativeType("uint32_t")
        public int sceneMeshCount() { return XrSceneMeshesMSFT.nsceneMeshCount(address()); }
        /** @return a {@link XrSceneMeshMSFT.Buffer} view of the struct array pointed to by the {@code sceneMeshes} field. */
        @Nullable
        @NativeType("XrSceneMeshMSFT *")
        public XrSceneMeshMSFT.Buffer sceneMeshes() { return XrSceneMeshesMSFT.nsceneMeshes(address()); }

        /** Sets the specified value to the {@code type} field. */
        public Buffer type(@NativeType("XrStructureType") int value) { XrSceneMeshesMSFT.ntype(address(), value); return this; }
        /** Sets the {@link MSFTSceneUnderstanding#XR_TYPE_SCENE_MESHES_MSFT TYPE_SCENE_MESHES_MSFT} value to the {@code type} field. */
        public Buffer type$Default() { return type(MSFTSceneUnderstanding.XR_TYPE_SCENE_MESHES_MSFT); }
        /** Sets the specified value to the {@code next} field. */
        public Buffer next(@NativeType("void *") long value) { XrSceneMeshesMSFT.nnext(address(), value); return this; }
        /** Sets the specified value to the {@code sceneMeshCount} field. */
        public Buffer sceneMeshCount(@NativeType("uint32_t") int value) { XrSceneMeshesMSFT.nsceneMeshCount(address(), value); return this; }
        /** Sets the address of the specified {@link XrSceneMeshMSFT.Buffer} to the {@code sceneMeshes} field. */
        public Buffer sceneMeshes(@Nullable @NativeType("XrSceneMeshMSFT *") XrSceneMeshMSFT.Buffer value) { XrSceneMeshesMSFT.nsceneMeshes(address(), value); return this; }

    }

}