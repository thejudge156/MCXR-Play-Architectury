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
 * struct XrControllerModelPropertiesMSFT {
 *     XrStructureType type;
 *     void * next;
 *     uint32_t nodeCapacityInput;
 *     uint32_t nodeCountOutput;
 *     {@link XrControllerModelNodePropertiesMSFT XrControllerModelNodePropertiesMSFT} * nodeProperties;
 * }</code></pre>
 */
public class XrControllerModelPropertiesMSFT extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        TYPE,
        NEXT,
        NODECAPACITYINPUT,
        NODECOUNTOUTPUT,
        NODEPROPERTIES;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(4),
            __member(4),
            __member(POINTER_SIZE)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        TYPE = layout.offsetof(0);
        NEXT = layout.offsetof(1);
        NODECAPACITYINPUT = layout.offsetof(2);
        NODECOUNTOUTPUT = layout.offsetof(3);
        NODEPROPERTIES = layout.offsetof(4);
    }

    /**
     * Creates a {@code XrControllerModelPropertiesMSFT} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public XrControllerModelPropertiesMSFT(ByteBuffer container) {
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
    /** @return the value of the {@code nodeCapacityInput} field. */
    @NativeType("uint32_t")
    public int nodeCapacityInput() { return nnodeCapacityInput(address()); }
    /** @return the value of the {@code nodeCountOutput} field. */
    @NativeType("uint32_t")
    public int nodeCountOutput() { return nnodeCountOutput(address()); }
    /** @return a {@link XrControllerModelNodePropertiesMSFT.Buffer} view of the struct array pointed to by the {@code nodeProperties} field. */
    @Nullable
    @NativeType("XrControllerModelNodePropertiesMSFT *")
    public XrControllerModelNodePropertiesMSFT.Buffer nodeProperties() { return nnodeProperties(address()); }

    /** Sets the specified value to the {@code type} field. */
    public XrControllerModelPropertiesMSFT type(@NativeType("XrStructureType") int value) { ntype(address(), value); return this; }
    /** Sets the {@link MSFTControllerModel#XR_TYPE_CONTROLLER_MODEL_PROPERTIES_MSFT TYPE_CONTROLLER_MODEL_PROPERTIES_MSFT} value to the {@code type} field. */
    public XrControllerModelPropertiesMSFT type$Default() { return type(MSFTControllerModel.XR_TYPE_CONTROLLER_MODEL_PROPERTIES_MSFT); }
    /** Sets the specified value to the {@code next} field. */
    public XrControllerModelPropertiesMSFT next(@NativeType("void *") long value) { nnext(address(), value); return this; }
    /** Sets the specified value to the {@code nodeCapacityInput} field. */
    public XrControllerModelPropertiesMSFT nodeCapacityInput(@NativeType("uint32_t") int value) { nnodeCapacityInput(address(), value); return this; }
    /** Sets the specified value to the {@code nodeCountOutput} field. */
    public XrControllerModelPropertiesMSFT nodeCountOutput(@NativeType("uint32_t") int value) { nnodeCountOutput(address(), value); return this; }
    /** Sets the address of the specified {@link XrControllerModelNodePropertiesMSFT.Buffer} to the {@code nodeProperties} field. */
    public XrControllerModelPropertiesMSFT nodeProperties(@Nullable @NativeType("XrControllerModelNodePropertiesMSFT *") XrControllerModelNodePropertiesMSFT.Buffer value) { nnodeProperties(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public XrControllerModelPropertiesMSFT set(
        int type,
        long next,
        int nodeCapacityInput,
        int nodeCountOutput,
        @Nullable XrControllerModelNodePropertiesMSFT.Buffer nodeProperties
    ) {
        type(type);
        next(next);
        nodeCapacityInput(nodeCapacityInput);
        nodeCountOutput(nodeCountOutput);
        nodeProperties(nodeProperties);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public XrControllerModelPropertiesMSFT set(XrControllerModelPropertiesMSFT src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code XrControllerModelPropertiesMSFT} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static XrControllerModelPropertiesMSFT malloc() {
        return wrap(XrControllerModelPropertiesMSFT.class, nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@code XrControllerModelPropertiesMSFT} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static XrControllerModelPropertiesMSFT calloc() {
        return wrap(XrControllerModelPropertiesMSFT.class, nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@code XrControllerModelPropertiesMSFT} instance allocated with {@link BufferUtils}. */
    public static XrControllerModelPropertiesMSFT create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return wrap(XrControllerModelPropertiesMSFT.class, memAddress(container), container);
    }

    /** Returns a new {@code XrControllerModelPropertiesMSFT} instance for the specified memory address. */
    public static XrControllerModelPropertiesMSFT create(long address) {
        return wrap(XrControllerModelPropertiesMSFT.class, address);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static XrControllerModelPropertiesMSFT createSafe(long address) {
        return address == NULL ? null : wrap(XrControllerModelPropertiesMSFT.class, address);
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
    public static XrControllerModelPropertiesMSFT.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : wrap(Buffer.class, address, capacity);
    }


    /**
     * Returns a new {@code XrControllerModelPropertiesMSFT} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static XrControllerModelPropertiesMSFT malloc(MemoryStack stack) {
        return wrap(XrControllerModelPropertiesMSFT.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@code XrControllerModelPropertiesMSFT} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static XrControllerModelPropertiesMSFT calloc(MemoryStack stack) {
        return wrap(XrControllerModelPropertiesMSFT.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
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
    public static int ntype(long struct) { return UNSAFE.getInt(null, struct + XrControllerModelPropertiesMSFT.TYPE); }
    /** Unsafe version of {@link #next}. */
    public static long nnext(long struct) { return memGetAddress(struct + XrControllerModelPropertiesMSFT.NEXT); }
    /** Unsafe version of {@link #nodeCapacityInput}. */
    public static int nnodeCapacityInput(long struct) { return UNSAFE.getInt(null, struct + XrControllerModelPropertiesMSFT.NODECAPACITYINPUT); }
    /** Unsafe version of {@link #nodeCountOutput}. */
    public static int nnodeCountOutput(long struct) { return UNSAFE.getInt(null, struct + XrControllerModelPropertiesMSFT.NODECOUNTOUTPUT); }
    /** Unsafe version of {@link #nodeProperties}. */
    @Nullable public static XrControllerModelNodePropertiesMSFT.Buffer nnodeProperties(long struct) { return XrControllerModelNodePropertiesMSFT.createSafe(memGetAddress(struct + XrControllerModelPropertiesMSFT.NODEPROPERTIES), nnodeCapacityInput(struct)); }

    /** Unsafe version of {@link #type(int) type}. */
    public static void ntype(long struct, int value) { UNSAFE.putInt(null, struct + XrControllerModelPropertiesMSFT.TYPE, value); }
    /** Unsafe version of {@link #next(long) next}. */
    public static void nnext(long struct, long value) { memPutAddress(struct + XrControllerModelPropertiesMSFT.NEXT, value); }
    /** Sets the specified value to the {@code nodeCapacityInput} field of the specified {@code struct}. */
    public static void nnodeCapacityInput(long struct, int value) { UNSAFE.putInt(null, struct + XrControllerModelPropertiesMSFT.NODECAPACITYINPUT, value); }
    /** Unsafe version of {@link #nodeCountOutput(int) nodeCountOutput}. */
    public static void nnodeCountOutput(long struct, int value) { UNSAFE.putInt(null, struct + XrControllerModelPropertiesMSFT.NODECOUNTOUTPUT, value); }
    /** Unsafe version of {@link #nodeProperties(XrControllerModelNodePropertiesMSFT.Buffer) nodeProperties}. */
    public static void nnodeProperties(long struct, @Nullable XrControllerModelNodePropertiesMSFT.Buffer value) { memPutAddress(struct + XrControllerModelPropertiesMSFT.NODEPROPERTIES, memAddressSafe(value)); if (value != null) { nnodeCapacityInput(struct, value.remaining()); } }

    // -----------------------------------

    /** An array of {@link XrControllerModelPropertiesMSFT} structs. */
    public static class Buffer extends StructBuffer<XrControllerModelPropertiesMSFT, Buffer> implements NativeResource {

        private static final XrControllerModelPropertiesMSFT ELEMENT_FACTORY = XrControllerModelPropertiesMSFT.create(-1L);

        /**
         * Creates a new {@code XrControllerModelPropertiesMSFT.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link XrControllerModelPropertiesMSFT#SIZEOF}, and its mark will be undefined.
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
        protected XrControllerModelPropertiesMSFT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code type} field. */
        @NativeType("XrStructureType")
        public int type() { return XrControllerModelPropertiesMSFT.ntype(address()); }
        /** @return the value of the {@code next} field. */
        @NativeType("void *")
        public long next() { return XrControllerModelPropertiesMSFT.nnext(address()); }
        /** @return the value of the {@code nodeCapacityInput} field. */
        @NativeType("uint32_t")
        public int nodeCapacityInput() { return XrControllerModelPropertiesMSFT.nnodeCapacityInput(address()); }
        /** @return the value of the {@code nodeCountOutput} field. */
        @NativeType("uint32_t")
        public int nodeCountOutput() { return XrControllerModelPropertiesMSFT.nnodeCountOutput(address()); }
        /** @return a {@link XrControllerModelNodePropertiesMSFT.Buffer} view of the struct array pointed to by the {@code nodeProperties} field. */
        @Nullable
        @NativeType("XrControllerModelNodePropertiesMSFT *")
        public XrControllerModelNodePropertiesMSFT.Buffer nodeProperties() { return XrControllerModelPropertiesMSFT.nnodeProperties(address()); }

        /** Sets the specified value to the {@code type} field. */
        public Buffer type(@NativeType("XrStructureType") int value) { XrControllerModelPropertiesMSFT.ntype(address(), value); return this; }
        /** Sets the {@link MSFTControllerModel#XR_TYPE_CONTROLLER_MODEL_PROPERTIES_MSFT TYPE_CONTROLLER_MODEL_PROPERTIES_MSFT} value to the {@code type} field. */
        public Buffer type$Default() { return type(MSFTControllerModel.XR_TYPE_CONTROLLER_MODEL_PROPERTIES_MSFT); }
        /** Sets the specified value to the {@code next} field. */
        public Buffer next(@NativeType("void *") long value) { XrControllerModelPropertiesMSFT.nnext(address(), value); return this; }
        /** Sets the specified value to the {@code nodeCapacityInput} field. */
        public Buffer nodeCapacityInput(@NativeType("uint32_t") int value) { XrControllerModelPropertiesMSFT.nnodeCapacityInput(address(), value); return this; }
        /** Sets the specified value to the {@code nodeCountOutput} field. */
        public Buffer nodeCountOutput(@NativeType("uint32_t") int value) { XrControllerModelPropertiesMSFT.nnodeCountOutput(address(), value); return this; }
        /** Sets the address of the specified {@link XrControllerModelNodePropertiesMSFT.Buffer} to the {@code nodeProperties} field. */
        public Buffer nodeProperties(@Nullable @NativeType("XrControllerModelNodePropertiesMSFT *") XrControllerModelNodePropertiesMSFT.Buffer value) { XrControllerModelPropertiesMSFT.nnodeProperties(address(), value); return this; }

    }

}