/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package AvroSchema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class deal_log extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1869276160914705748L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"deal_log\",\"namespace\":\"AvroSchema\",\"fields\":[{\"name\":\"d_dm\",\"type\":\"string\"},{\"name\":\"log_id\",\"type\":\"string\"},{\"name\":\"log_dtm\",\"type\":\"string\"},{\"name\":\"rt_code\",\"type\":\"string\"},{\"name\":\"cust_id\",\"type\":\"string\"},{\"name\":\"d_txt\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<deal_log> ENCODER =
      new BinaryMessageEncoder<deal_log>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<deal_log> DECODER =
      new BinaryMessageDecoder<deal_log>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<deal_log> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<deal_log> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<deal_log>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this deal_log to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a deal_log from a ByteBuffer. */
  public static deal_log fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence d_dm;
  @Deprecated public java.lang.CharSequence log_id;
  @Deprecated public java.lang.CharSequence log_dtm;
  @Deprecated public java.lang.CharSequence rt_code;
  @Deprecated public java.lang.CharSequence cust_id;
  @Deprecated public java.lang.CharSequence d_txt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public deal_log() {}

  /**
   * All-args constructor.
   * @param d_dm The new value for d_dm
   * @param log_id The new value for log_id
   * @param log_dtm The new value for log_dtm
   * @param rt_code The new value for rt_code
   * @param cust_id The new value for cust_id
   * @param d_txt The new value for d_txt
   */
  public deal_log(java.lang.CharSequence d_dm, java.lang.CharSequence log_id, java.lang.CharSequence log_dtm, java.lang.CharSequence rt_code, java.lang.CharSequence cust_id, java.lang.CharSequence d_txt) {
    this.d_dm = d_dm;
    this.log_id = log_id;
    this.log_dtm = log_dtm;
    this.rt_code = rt_code;
    this.cust_id = cust_id;
    this.d_txt = d_txt;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return d_dm;
    case 1: return log_id;
    case 2: return log_dtm;
    case 3: return rt_code;
    case 4: return cust_id;
    case 5: return d_txt;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: d_dm = (java.lang.CharSequence)value$; break;
    case 1: log_id = (java.lang.CharSequence)value$; break;
    case 2: log_dtm = (java.lang.CharSequence)value$; break;
    case 3: rt_code = (java.lang.CharSequence)value$; break;
    case 4: cust_id = (java.lang.CharSequence)value$; break;
    case 5: d_txt = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'd_dm' field.
   * @return The value of the 'd_dm' field.
   */
  public java.lang.CharSequence getDDm() {
    return d_dm;
  }

  /**
   * Sets the value of the 'd_dm' field.
   * @param value the value to set.
   */
  public void setDDm(java.lang.CharSequence value) {
    this.d_dm = value;
  }

  /**
   * Gets the value of the 'log_id' field.
   * @return The value of the 'log_id' field.
   */
  public java.lang.CharSequence getLogId() {
    return log_id;
  }

  /**
   * Sets the value of the 'log_id' field.
   * @param value the value to set.
   */
  public void setLogId(java.lang.CharSequence value) {
    this.log_id = value;
  }

  /**
   * Gets the value of the 'log_dtm' field.
   * @return The value of the 'log_dtm' field.
   */
  public java.lang.CharSequence getLogDtm() {
    return log_dtm;
  }

  /**
   * Sets the value of the 'log_dtm' field.
   * @param value the value to set.
   */
  public void setLogDtm(java.lang.CharSequence value) {
    this.log_dtm = value;
  }

  /**
   * Gets the value of the 'rt_code' field.
   * @return The value of the 'rt_code' field.
   */
  public java.lang.CharSequence getRtCode() {
    return rt_code;
  }

  /**
   * Sets the value of the 'rt_code' field.
   * @param value the value to set.
   */
  public void setRtCode(java.lang.CharSequence value) {
    this.rt_code = value;
  }

  /**
   * Gets the value of the 'cust_id' field.
   * @return The value of the 'cust_id' field.
   */
  public java.lang.CharSequence getCustId() {
    return cust_id;
  }

  /**
   * Sets the value of the 'cust_id' field.
   * @param value the value to set.
   */
  public void setCustId(java.lang.CharSequence value) {
    this.cust_id = value;
  }

  /**
   * Gets the value of the 'd_txt' field.
   * @return The value of the 'd_txt' field.
   */
  public java.lang.CharSequence getDTxt() {
    return d_txt;
  }

  /**
   * Sets the value of the 'd_txt' field.
   * @param value the value to set.
   */
  public void setDTxt(java.lang.CharSequence value) {
    this.d_txt = value;
  }

  /**
   * Creates a new deal_log RecordBuilder.
   * @return A new deal_log RecordBuilder
   */
  public static AvroSchema.deal_log.Builder newBuilder() {
    return new AvroSchema.deal_log.Builder();
  }

  /**
   * Creates a new deal_log RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new deal_log RecordBuilder
   */
  public static AvroSchema.deal_log.Builder newBuilder(AvroSchema.deal_log.Builder other) {
    return new AvroSchema.deal_log.Builder(other);
  }

  /**
   * Creates a new deal_log RecordBuilder by copying an existing deal_log instance.
   * @param other The existing instance to copy.
   * @return A new deal_log RecordBuilder
   */
  public static AvroSchema.deal_log.Builder newBuilder(AvroSchema.deal_log other) {
    return new AvroSchema.deal_log.Builder(other);
  }

  /**
   * RecordBuilder for deal_log instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<deal_log>
    implements org.apache.avro.data.RecordBuilder<deal_log> {

    private java.lang.CharSequence d_dm;
    private java.lang.CharSequence log_id;
    private java.lang.CharSequence log_dtm;
    private java.lang.CharSequence rt_code;
    private java.lang.CharSequence cust_id;
    private java.lang.CharSequence d_txt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(AvroSchema.deal_log.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.d_dm)) {
        this.d_dm = data().deepCopy(fields()[0].schema(), other.d_dm);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.log_id)) {
        this.log_id = data().deepCopy(fields()[1].schema(), other.log_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.log_dtm)) {
        this.log_dtm = data().deepCopy(fields()[2].schema(), other.log_dtm);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.rt_code)) {
        this.rt_code = data().deepCopy(fields()[3].schema(), other.rt_code);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.cust_id)) {
        this.cust_id = data().deepCopy(fields()[4].schema(), other.cust_id);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.d_txt)) {
        this.d_txt = data().deepCopy(fields()[5].schema(), other.d_txt);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing deal_log instance
     * @param other The existing instance to copy.
     */
    private Builder(AvroSchema.deal_log other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.d_dm)) {
        this.d_dm = data().deepCopy(fields()[0].schema(), other.d_dm);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.log_id)) {
        this.log_id = data().deepCopy(fields()[1].schema(), other.log_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.log_dtm)) {
        this.log_dtm = data().deepCopy(fields()[2].schema(), other.log_dtm);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.rt_code)) {
        this.rt_code = data().deepCopy(fields()[3].schema(), other.rt_code);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.cust_id)) {
        this.cust_id = data().deepCopy(fields()[4].schema(), other.cust_id);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.d_txt)) {
        this.d_txt = data().deepCopy(fields()[5].schema(), other.d_txt);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'd_dm' field.
      * @return The value.
      */
    public java.lang.CharSequence getDDm() {
      return d_dm;
    }

    /**
      * Sets the value of the 'd_dm' field.
      * @param value The value of 'd_dm'.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder setDDm(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.d_dm = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'd_dm' field has been set.
      * @return True if the 'd_dm' field has been set, false otherwise.
      */
    public boolean hasDDm() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'd_dm' field.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder clearDDm() {
      d_dm = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'log_id' field.
      * @return The value.
      */
    public java.lang.CharSequence getLogId() {
      return log_id;
    }

    /**
      * Sets the value of the 'log_id' field.
      * @param value The value of 'log_id'.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder setLogId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.log_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'log_id' field has been set.
      * @return True if the 'log_id' field has been set, false otherwise.
      */
    public boolean hasLogId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'log_id' field.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder clearLogId() {
      log_id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'log_dtm' field.
      * @return The value.
      */
    public java.lang.CharSequence getLogDtm() {
      return log_dtm;
    }

    /**
      * Sets the value of the 'log_dtm' field.
      * @param value The value of 'log_dtm'.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder setLogDtm(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.log_dtm = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'log_dtm' field has been set.
      * @return True if the 'log_dtm' field has been set, false otherwise.
      */
    public boolean hasLogDtm() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'log_dtm' field.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder clearLogDtm() {
      log_dtm = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'rt_code' field.
      * @return The value.
      */
    public java.lang.CharSequence getRtCode() {
      return rt_code;
    }

    /**
      * Sets the value of the 'rt_code' field.
      * @param value The value of 'rt_code'.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder setRtCode(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.rt_code = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'rt_code' field has been set.
      * @return True if the 'rt_code' field has been set, false otherwise.
      */
    public boolean hasRtCode() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'rt_code' field.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder clearRtCode() {
      rt_code = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'cust_id' field.
      * @return The value.
      */
    public java.lang.CharSequence getCustId() {
      return cust_id;
    }

    /**
      * Sets the value of the 'cust_id' field.
      * @param value The value of 'cust_id'.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder setCustId(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.cust_id = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'cust_id' field has been set.
      * @return True if the 'cust_id' field has been set, false otherwise.
      */
    public boolean hasCustId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'cust_id' field.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder clearCustId() {
      cust_id = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'd_txt' field.
      * @return The value.
      */
    public java.lang.CharSequence getDTxt() {
      return d_txt;
    }

    /**
      * Sets the value of the 'd_txt' field.
      * @param value The value of 'd_txt'.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder setDTxt(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.d_txt = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'd_txt' field has been set.
      * @return True if the 'd_txt' field has been set, false otherwise.
      */
    public boolean hasDTxt() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'd_txt' field.
      * @return This builder.
      */
    public AvroSchema.deal_log.Builder clearDTxt() {
      d_txt = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public deal_log build() {
      try {
        deal_log record = new deal_log();
        record.d_dm = fieldSetFlags()[0] ? this.d_dm : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.log_id = fieldSetFlags()[1] ? this.log_id : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.log_dtm = fieldSetFlags()[2] ? this.log_dtm : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.rt_code = fieldSetFlags()[3] ? this.rt_code : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.cust_id = fieldSetFlags()[4] ? this.cust_id : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.d_txt = fieldSetFlags()[5] ? this.d_txt : (java.lang.CharSequence) defaultValue(fields()[5]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<deal_log>
    WRITER$ = (org.apache.avro.io.DatumWriter<deal_log>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<deal_log>
    READER$ = (org.apache.avro.io.DatumReader<deal_log>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
