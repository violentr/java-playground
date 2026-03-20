package com.violentr.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SortAlgorithmImpl {
    @Autowired
    private SortAlgorithm sortAlgorithm;

    public SortAlgorithmImpl(SortAlgorithm algorithm) {
        this.sortAlgorithm = algorithm;
    }
    public int[] sort (int[] array) {
       return  this.sortAlgorithm.sort(array);
    }

}
