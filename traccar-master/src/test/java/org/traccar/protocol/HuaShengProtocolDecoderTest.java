package org.traccar.protocol;

import org.junit.Test;
import org.traccar.ProtocolTest;

public class HuaShengProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        HuaShengProtocolDecoder decoder = new HuaShengProtocolDecoder(null);

        verifyNull(decoder, binary(
                "c0010c003c0002000000000044020010a0014f42445f3347315f56322e320013a0043335353835353035313032303536360006a08700000006a0a105c9c0"));

        verifyNull(decoder, binary(
                "c000000077aa0200000000000e000100143347315f48312e315f56312e30372e54000300133335353835353035303434303635380004000b3531323030303000050005010006000400070004000800050000090018383936313032353431343533333239313833360d000a000f796573696e7465726e6574c0"));

        verifyPosition(decoder, binary(
                "c00000004baa0000000000000f8000000031363130323030373236333600e6d4f9ffcc78c700000022003600000001001500000000000000000000059bffffffffff0005000a040300000253c0"));

        verifyPosition(decoder, binary(
                "c00000004baa000000000000098000000031363130303732323236343700e6d4efffcc789f000000000026000000010015000000000000000000000488ffffffffff0005000a10060000008dc0"));

        verifyPosition(decoder, binary(
                "c00000004baa000000000000098000000031363130303732323236343700e6d4efffcc789f000000000026000000010015000000000000000000000488ffffffffff0005000a10060000008dc0"));

        verifyPosition(decoder, binary(
                "c00000004baa00000000000005c400000131363037303630323537303800e6c82effcc7cb0003900a30089000000010015000000000000000000f20559ff577ce3980005000a060500000087c0"));

        verifyNull(decoder, binary(
                "c0010c003e0002000000000010020012a0014f42445f3347315f56312e302e330013a0043335353835353035303434303635380006a08701000006a0a1035fc0"));

        verifyNull(decoder, binary(
                "c0010c00120060000000000004000600010100c0"));

        verifyNull(decoder, binary(
                "C00000007EAA020000000000010001001047315F48312E305F56312E3000030013383632393530303238353334333036000400144C342D56374C673979497A7A2D724A6D0005000501000600084341524400070008434152440008000500000900183839383630303530313931343436313130393134000A0009434D4E4554C0"));

        verifyPosition(decoder, binary(
                "C000000041AA00000000000030C000000031353035323630373538323800ADDCC100226AEF0000000000120005000100151206EF0504E99975002903EB80556492CEC0"));

    }

}
