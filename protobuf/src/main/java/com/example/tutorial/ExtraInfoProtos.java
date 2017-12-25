// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: extrainfo.proto

package com.example.tutorial;

public final class ExtraInfoProtos {
  private ExtraInfoProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ExtraInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:tutorial.ExtraInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */
    int getValuesCount();
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */
    boolean containsValues(
        java.lang.String key);
    /**
     * Use {@link #getValuesMap()} instead.
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, java.lang.String>
    getValues();
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */
    java.util.Map<java.lang.String, java.lang.String>
    getValuesMap();
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */

    java.lang.String getValuesOrDefault(
        java.lang.String key,
        java.lang.String defaultValue);
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */

    java.lang.String getValuesOrThrow(
        java.lang.String key);
  }
  /**
   * Protobuf type {@code tutorial.ExtraInfo}
   */
  public  static final class ExtraInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:tutorial.ExtraInfo)
      ExtraInfoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ExtraInfo.newBuilder() to construct.
    private ExtraInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ExtraInfo() {
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ExtraInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                values_ = com.google.protobuf.MapField.newMapField(
                    ValuesDefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000001;
              }
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              values__ = input.readMessage(
                  ValuesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              values_.getMutableMap().put(
                  values__.getKey(), values__.getValue());
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.tutorial.ExtraInfoProtos.internal_static_tutorial_ExtraInfo_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetValues();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.tutorial.ExtraInfoProtos.internal_static_tutorial_ExtraInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.tutorial.ExtraInfoProtos.ExtraInfo.class, com.example.tutorial.ExtraInfoProtos.ExtraInfo.Builder.class);
    }

    public static final int VALUES_FIELD_NUMBER = 3;
    private static final class ValuesDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          java.lang.String, java.lang.String> defaultEntry =
              com.google.protobuf.MapEntry
              .<java.lang.String, java.lang.String>newDefaultInstance(
                  com.example.tutorial.ExtraInfoProtos.internal_static_tutorial_ExtraInfo_ValuesEntry_descriptor, 
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> values_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetValues() {
      if (values_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            ValuesDefaultEntryHolder.defaultEntry);
      }
      return values_;
    }

    public int getValuesCount() {
      return internalGetValues().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */

    public boolean containsValues(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetValues().getMap().containsKey(key);
    }
    /**
     * Use {@link #getValuesMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getValues() {
      return getValuesMap();
    }
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getValuesMap() {
      return internalGetValues().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */

    public java.lang.String getValuesOrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetValues().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; values = 3;</code>
     */

    public java.lang.String getValuesOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetValues().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      com.google.protobuf.GeneratedMessageV3
        .serializeStringMapTo(
          output,
          internalGetValues(),
          ValuesDefaultEntryHolder.defaultEntry,
          3);
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : internalGetValues().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        values__ = ValuesDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(3, values__);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.example.tutorial.ExtraInfoProtos.ExtraInfo)) {
        return super.equals(obj);
      }
      com.example.tutorial.ExtraInfoProtos.ExtraInfo other = (com.example.tutorial.ExtraInfoProtos.ExtraInfo) obj;

      boolean result = true;
      result = result && internalGetValues().equals(
          other.internalGetValues());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (!internalGetValues().getMap().isEmpty()) {
        hash = (37 * hash) + VALUES_FIELD_NUMBER;
        hash = (53 * hash) + internalGetValues().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.example.tutorial.ExtraInfoProtos.ExtraInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code tutorial.ExtraInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:tutorial.ExtraInfo)
        com.example.tutorial.ExtraInfoProtos.ExtraInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.example.tutorial.ExtraInfoProtos.internal_static_tutorial_ExtraInfo_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 3:
            return internalGetValues();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(
          int number) {
        switch (number) {
          case 3:
            return internalGetMutableValues();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.example.tutorial.ExtraInfoProtos.internal_static_tutorial_ExtraInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.example.tutorial.ExtraInfoProtos.ExtraInfo.class, com.example.tutorial.ExtraInfoProtos.ExtraInfo.Builder.class);
      }

      // Construct using com.example.tutorial.ExtraInfoProtos.ExtraInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        internalGetMutableValues().clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.example.tutorial.ExtraInfoProtos.internal_static_tutorial_ExtraInfo_descriptor;
      }

      public com.example.tutorial.ExtraInfoProtos.ExtraInfo getDefaultInstanceForType() {
        return com.example.tutorial.ExtraInfoProtos.ExtraInfo.getDefaultInstance();
      }

      public com.example.tutorial.ExtraInfoProtos.ExtraInfo build() {
        com.example.tutorial.ExtraInfoProtos.ExtraInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.example.tutorial.ExtraInfoProtos.ExtraInfo buildPartial() {
        com.example.tutorial.ExtraInfoProtos.ExtraInfo result = new com.example.tutorial.ExtraInfoProtos.ExtraInfo(this);
        int from_bitField0_ = bitField0_;
        result.values_ = internalGetValues();
        result.values_.makeImmutable();
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.example.tutorial.ExtraInfoProtos.ExtraInfo) {
          return mergeFrom((com.example.tutorial.ExtraInfoProtos.ExtraInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.example.tutorial.ExtraInfoProtos.ExtraInfo other) {
        if (other == com.example.tutorial.ExtraInfoProtos.ExtraInfo.getDefaultInstance()) return this;
        internalGetMutableValues().mergeFrom(
            other.internalGetValues());
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.example.tutorial.ExtraInfoProtos.ExtraInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.example.tutorial.ExtraInfoProtos.ExtraInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.MapField<
          java.lang.String, java.lang.String> values_;
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetValues() {
        if (values_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              ValuesDefaultEntryHolder.defaultEntry);
        }
        return values_;
      }
      private com.google.protobuf.MapField<java.lang.String, java.lang.String>
      internalGetMutableValues() {
        onChanged();;
        if (values_ == null) {
          values_ = com.google.protobuf.MapField.newMapField(
              ValuesDefaultEntryHolder.defaultEntry);
        }
        if (!values_.isMutable()) {
          values_ = values_.copy();
        }
        return values_;
      }

      public int getValuesCount() {
        return internalGetValues().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; values = 3;</code>
       */

      public boolean containsValues(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        return internalGetValues().getMap().containsKey(key);
      }
      /**
       * Use {@link #getValuesMap()} instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String> getValues() {
        return getValuesMap();
      }
      /**
       * <code>map&lt;string, string&gt; values = 3;</code>
       */

      public java.util.Map<java.lang.String, java.lang.String> getValuesMap() {
        return internalGetValues().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; values = 3;</code>
       */

      public java.lang.String getValuesOrDefault(
          java.lang.String key,
          java.lang.String defaultValue) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetValues().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; values = 3;</code>
       */

      public java.lang.String getValuesOrThrow(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.String> map =
            internalGetValues().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearValues() {
        internalGetMutableValues().getMutableMap()
            .clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; values = 3;</code>
       */

      public Builder removeValues(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        internalGetMutableValues().getMutableMap()
            .remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, java.lang.String>
      getMutableValues() {
        return internalGetMutableValues().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; values = 3;</code>
       */
      public Builder putValues(
          java.lang.String key,
          java.lang.String value) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        if (value == null) { throw new java.lang.NullPointerException(); }
        internalGetMutableValues().getMutableMap()
            .put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; values = 3;</code>
       */

      public Builder putAllValues(
          java.util.Map<java.lang.String, java.lang.String> values) {
        internalGetMutableValues().getMutableMap()
            .putAll(values);
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:tutorial.ExtraInfo)
    }

    // @@protoc_insertion_point(class_scope:tutorial.ExtraInfo)
    private static final com.example.tutorial.ExtraInfoProtos.ExtraInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.example.tutorial.ExtraInfoProtos.ExtraInfo();
    }

    public static com.example.tutorial.ExtraInfoProtos.ExtraInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ExtraInfo>
        PARSER = new com.google.protobuf.AbstractParser<ExtraInfo>() {
      public ExtraInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ExtraInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ExtraInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ExtraInfo> getParserForType() {
      return PARSER;
    }

    public com.example.tutorial.ExtraInfoProtos.ExtraInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_ExtraInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_ExtraInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_ExtraInfo_ValuesEntry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_ExtraInfo_ValuesEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017extrainfo.proto\022\010tutorial\"k\n\tExtraInfo" +
      "\022/\n\006values\030\003 \003(\0132\037.tutorial.ExtraInfo.Va" +
      "luesEntry\032-\n\013ValuesEntry\022\013\n\003key\030\001 \001(\t\022\r\n" +
      "\005value\030\002 \001(\t:\0028\001B\'\n\024com.example.tutorial" +
      "B\017ExtraInfoProtosb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_tutorial_ExtraInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_ExtraInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_ExtraInfo_descriptor,
        new java.lang.String[] { "Values", });
    internal_static_tutorial_ExtraInfo_ValuesEntry_descriptor =
      internal_static_tutorial_ExtraInfo_descriptor.getNestedTypes().get(0);
    internal_static_tutorial_ExtraInfo_ValuesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_ExtraInfo_ValuesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
