package com.violentr.spring.utils;

import org.springframework.stereotype.Component;

@Component
public class BubleSortAlgorithm  implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        return new int[]{1,5,8};
    }
}
