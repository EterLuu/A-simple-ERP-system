package pdc.assignment.erp.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {

    @Test
    void judgeUsername() {
        assertTrue(Judgement.judgeName("Admin"));
        assertTrue(Judgement.judgeName("Alex"));
        assertTrue(Judgement.judgeName("Me"));
        assertTrue(Judgement.judgeName("Wu"));
        assertTrue(Judgement.judgeName("Mike"));
        assertFalse(Judgement.judgeName("@#$%^"));
        assertFalse(Judgement.judgeName(""));
        assertFalse(Judgement.judgeName("%@asdww"));
        assertFalse(Judgement.judgeName(")dasdfwfe"));
        assertFalse(Judgement.judgeName("adfsgeragergergergg"));
    }

    @Test
    void judgePassword() {
        assertTrue(Judgement.judgePassword("123456"));
        assertTrue(Judgement.judgePassword("12356789"));
        assertTrue(Judgement.judgePassword("asdfghjkl"));
        assertTrue(Judgement.judgePassword("2sd3r4tfg5g"));
        assertTrue(Judgement.judgePassword("1at7hjn2wq"));
        assertFalse(Judgement.judgePassword("!@#$%^&*("));
        assertFalse(Judgement.judgePassword("#fghjhdbsjandasf"));
        assertFalse(Judgement.judgePassword("sfdfshfgdsjfgdsjhfgdsjfgdhsjfgdsfgdhsfgsdhjfgdshjfgdsf"));
        assertFalse(Judgement.judgePassword("89whefwunfhq890hbasidadqf2wq4fwfwef234f435gregre"));
        assertFalse(Judgement.judgePassword("@"));
    }

    @Test
    void judgeNumber() {
        assertTrue(Judgement.judgeNumber("1234567"));
        assertTrue(Judgement.judgeNumber("12345.34"));
        assertTrue(Judgement.judgeNumber("122.11"));
        assertTrue(Judgement.judgeNumber("0.11"));
        assertTrue(Judgement.judgeNumber("1222"));
        assertFalse(Judgement.judgeNumber("231313131313"));
        assertFalse(Judgement.judgeNumber("1232313sd"));
        assertFalse(Judgement.judgeNumber("1231321111131"));
        assertFalse(Judgement.judgeNumber("%T&^(gbyuidq"));
        assertFalse(Judgement.judgeNumber("sdwdqw"));
        assertFalse(Judgement.judgeNumber("11."));
    }

    @Test
    void judgeString() {
        assertTrue(Judgement.judgeString("123456745646"));
        assertTrue(Judgement.judgeString("sdasdadadadasd"));
        assertTrue(Judgement.judgeString("asdsadsadada"));
        assertTrue(Judgement.judgeString("6d41aqf1se1af"));
        assertTrue(Judgement.judgeString("dadsadsadgwerg"));
        assertFalse(Judgement.judgeString("#%$&R^&T*H(J"));
        assertFalse(Judgement.judgeString("dadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwerg"));
        assertFalse(Judgement.judgeString("()"));
        assertFalse(Judgement.judgeString("$%"));
        assertFalse(Judgement.judgeString("!adawfef"));
    }

    @Test
    void judgeLongString() {
        assertTrue(Judgement.judgeString("123456745646"));
        assertTrue(Judgement.judgeString("sdasdadadadasd"));
        assertTrue(Judgement.judgeString("asdsadsadada"));
        assertTrue(Judgement.judgeString("6d41aqf1se1af"));
        assertTrue(Judgement.judgeString("dadsadsadgwerg"));
        assertFalse(Judgement.judgeString("#%$&R^&T*H(J"));
        assertFalse(Judgement.judgeString("dadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwerg"));
        assertFalse(Judgement.judgeString("()"));
        assertFalse(Judgement.judgeString("$%"));
        assertFalse(Judgement.judgeString("!adawfef"));
    }

    @Test
    void judgeStringWithoutEmpty(){
        assertTrue(Judgement.judgeStringWithoutEmpty("123456745646"));
        assertTrue(Judgement.judgeStringWithoutEmpty("sdasdadadadasd"));
        assertTrue(Judgement.judgeStringWithoutEmpty("asdsadsadada"));
        assertTrue(Judgement.judgeStringWithoutEmpty("6d41aqf1se1af"));
        assertTrue(Judgement.judgeStringWithoutEmpty("dadsadsadgwerg"));
        assertFalse(Judgement.judgeStringWithoutEmpty("#%$&R^&T*H(J"));
        assertFalse(Judgement.judgeStringWithoutEmpty("dadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwerg"));
        assertFalse(Judgement.judgeStringWithoutEmpty("()"));
        assertFalse(Judgement.judgeStringWithoutEmpty("$%"));
        assertFalse(Judgement.judgeStringWithoutEmpty("!adawfef"));
    }

    @Test
    void judgeLongStringWithoutEmpty() {
        assertTrue(Judgement.judgeLongStringWithoutEmpty("123456745646"));
        assertTrue(Judgement.judgeLongStringWithoutEmpty("sdasdadadadasd"));
        assertTrue(Judgement.judgeLongStringWithoutEmpty("asdsadsadada"));
        assertTrue(Judgement.judgeLongStringWithoutEmpty("6d41aqf1se1af"));
        assertTrue(Judgement.judgeLongStringWithoutEmpty("dadsadsadgwerg"));
        assertFalse(Judgement.judgeLongStringWithoutEmpty("#%$&R^&T*H(J"));
        assertFalse(Judgement.judgeLongStringWithoutEmpty("dadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwergdadsadsadgwerg"));
        assertFalse(Judgement.judgeLongStringWithoutEmpty("()"));
    }
}