package com.github.kayllon.douglas.command.argument;

public interface CommandArgument {

    Integer index();

    Object value();

    String stringValue();

    Integer integerValue();

    Double doubleValue();

    Boolean booleanValue();

    Long longValue();

    Float floatValue();

    Short shortValue();

    Byte byteValue();

    Character charValue();

    record CommandArgumentImpl(
        Integer index,
        Object value
    ) implements CommandArgument {

        @Override
        public String stringValue() {
            return this.value() instanceof final String string_value ? string_value : "";
        }

        @Override
        public Integer integerValue() {
            return this.value() instanceof final Integer integer_value ? integer_value : 0;
        }

        @Override
        public Double doubleValue() {
            return this.value() instanceof final Double double_value ? double_value : 0.0;
        }

        @Override
        public Boolean booleanValue() {
            return this.value() instanceof final Boolean boolean_value ? boolean_value : false;
        }

        @Override
        public Long longValue() {
            return this.value() instanceof final Long long_value ? long_value : 0L;
        }

        @Override
        public Float floatValue() {
            return this.value() instanceof final Float float_value ? float_value : 0.0F;
        }

        @Override
        public Short shortValue() {
            return this.value() instanceof final Short short_value ? short_value : 0;
        }

        @Override
        public Byte byteValue() {
            return this.value() instanceof final Byte byte_value ? byte_value : 0B0;
        }

        @Override
        public Character charValue() {
            return this.value() instanceof final Character char_value ? char_value : '\u0000';
        }

    }

}
