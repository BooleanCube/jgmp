package com.boole.jgm.math;

public class JGMFloat16 {

    public short bits;

    public JGMFloat16(float v) {
        if (this.isLarge()) bits = v < 0.0 ? (short) 0xfc00 : (short) 0x7c00;
        if (this.isNull()) bits = (short) 0xffff;

        int vi = (int) v;
        int t1, t2, t3;

        t1 = vi & 0x7fffffff;                // non-sign bits
        t2 = vi & 0x80000000;                // sign bit
        t3 = vi & 0x7f800000;                // exponent

        t1 >>= 13;                             // align mantissa on MSB
        t2 >>= 16;                             // shift sign bit into position

        t1 -= 0x1c000;                         // adjust bias

        t1 = (t3 < 0x38800000) ? 0 : t1;       // flush-to-zero
        t1 = (t3 > 0x8e000000) ? 0x7bff : t1;  // clamp-to-max
        t1 = (t3 == 0 ? 0 : t1);               // denormals-as-zero

        t1 |= t2;                              // re-insert sign bit

        bits = (short) t1;
    }

    public boolean isLarge() {
        return ((bits) & 0x7c00) == 0x7c00 && (bits & 0x03ff) == 0;
    }

    public boolean isNull() {
        return (bits & 0x7c00) == 0x7c00 && (bits & 0x03ff) == 1;
    }

}
