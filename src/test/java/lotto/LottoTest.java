package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 이하인 경우")
    @Test
    void createLottoByLessSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 당첨_번호와_일치하는_번호의_개수_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = new ArrayList<>(List.of(1, 2, 3, 7, 8, 9));
        int equalNumber = lotto.lottoNumbersContains(winNumber);
        assertThat(equalNumber).isEqualTo(3);
    }

    @Test
    void 당첨_번호의_값이_45보다_큰_경우(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호의_값이_1보다_작은_경우(){
        assertThatThrownBy(() -> new Lotto(List.of(0,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매한_로또_번호에_보너스_번호가_포함되어_있는_경우(){
        // 구매한 번호와 당첨 번호가 5개가 맞은 경우에만 해당
        // 당첨 번호가 1,2,3,4,5,7 가정
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int equalNumbers = lotto.bonusNumberContains(5, 6);
        assertThat(equalNumbers).isEqualTo(6);
    }
}