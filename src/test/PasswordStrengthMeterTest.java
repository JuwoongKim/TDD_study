package test;

import main.PasswordStrengthMeter.PasswordStrength;
import main.PasswordStrengthMeter.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
암호검사기

1. 입력받은 문자열을 바탕으로 규칙을 준수하는지에 따라 약함, 보통, 강함으로 분류한다.
2. 검사를 위한 규칙은 아래와 같다
    - 문자열의 길이는  8 이상이어야한다.
    - 0부터 9 사이의 숫자를 포함해야한다.
    - 대문자를 포함해야한다.
3, 세 규칙을 모두 충족시키면 강함, 2개의 규칙을 충족시키면 보통, 1개의 규칙을 충족시키면 약함으로 처리한다.
4. 위의 기능을 가진 암호검사기를 TDD 방식을 활용하여  구현한다.
 */

/*
기능 목록 작성

 */


class PasswordStrengthMeterTest {

    // 반복되는 코드를 변수로 또는 메서드로 묶어주어서 중복을 제거한다. test코드도 코드기 때문에 유지보수 대상

    private  PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = passwordStrengthMeter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    public void name(){
        // Test 실행환경이 준비되었는지 확인
    }

    @Test
    public void meetAllCriteria_Then_Strong(){
        // 기능 구현 목록이 완료되면, 가장 쉬운것부터 어려운것, 예외상황부터 먼저 처리한다.
        // 해당 맥락에서는 모든 조건을 충족시키는 것이 가장 구현하기 쉽기때문에, 이를 먼저 Test한다.

        assertStrength("12Abcedfg", PasswordStrength.STRONG);
        assertStrength("345!abBBds", PasswordStrength.STRONG);
    }

    @Test
    public void meetOtherCriteria_Except_For_Lenght_Then_Normal(){
        // 기능 추가1 - 길이가 8이하일때
        // NORMAL 조건을 만족하는 모든 조건을 test하는 것이 아니라, 기능 하나만 체크한다.

        assertStrength("12Abcd", PasswordStrength.NORMAL);
        assertStrength("12Ab!Cd", PasswordStrength.NORMAL);
    }

    @Test
    public void meetCriteria_Except_For_Number_Then_Normal(){
        assertStrength("Abcd@dddd", PasswordStrength.NORMAL);
        assertStrength("AD@ddrrrsd", PasswordStrength.NORMAL);

    }





}