package jzl.com.crackcodeinterview.Q;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Collections;

/**
 * jzl.com.crackcodeinterview.Q
 * Created by kingj on 2020/6/30 0030.
 * 17. 8 　 马戏团 人 塔。 有个 马戏团 正在 设计 叠罗汉 的 表演 节目， 一个人 要 站在 另一 人的 肩膀 上。 出于 实际 和 美观 的 考虑， 在上面 的 人 要比 下 面的 人 矮 一点 且 轻 一点。 已知 马戏团 每个 人的 身高 和 体重， 请 编写 代码 计算 叠罗汉 最多 能 叠 几个 人。
 */
public class Q8 {

    ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> array) {
        Collections.sort(array);
        ArrayList<ArrayList<HtWt>> solutions = new ArrayList<>();
        ArrayList<HtWt> bestSequence = null;

        for (int i = 0; i < array.size(); i++) {
            ArrayList<HtWt> longestAtIndex = bestSeqAtIndex(array, solutions, i);
            solutions.add(i, longestAtIndex);
            bestSequence = max(bestSequence, longestAtIndex);
        }
        return bestSequence;
    }

    ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array, ArrayList<ArrayList<HtWt>> solutions, int index) {
        HtWt value = array.get(index);
        ArrayList<HtWt> bestSequence = new ArrayList<HtWt>();
        for (int i = 0; i < index; i++) {
            ArrayList<HtWt> solution = solutions.get(i);
            if (canAppend(solution, value)) {
                bestSequence = max(solution, bestSequence);
            }
        }
        ArrayList<HtWt> best = (ArrayList<HtWt>) bestSequence.clone();
        best.add(value);
        return best;
    }

    boolean canAppend(ArrayList<HtWt> solution, HtWt value) {
        if (solution == null) {
            return false;
        }
        if (solution.size() == 0) {
            return true;
        }
        HtWt last = solution.get(solution.size() - 1);
        return last.isBefore(value);
    }

    ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null) {
            return seq2;
        } else if (seq2 == null) {
            return seq1;
        }
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }

    public class HtWt implements Comparable<HtWt> {
        private int height;
        private int weight;

        public HtWt(int h, int w) {
            height = h;
            weight = w;
        }

        @Override
        public int compareTo(HtWt second) {
            if (this.height != second.height) {
                return ((Integer) this.height).compareTo(second.height);
            } else {
                return ((Integer) this.weight).compareTo(second.weight);
            }

        }

        public boolean isBefore(HtWt other) {
            if (height < other.height && weight < other.weight) {
                return true;
            } else {
                return false;
            }

        }
    }

}
