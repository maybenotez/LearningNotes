package com.dark.knight.learn.project;

import java.util.List;

public class DefaultShortDistance implements ShortestDistance{

    /**
     * 初始化  车站信息
     */
    private int[][] distanceArray = {
            {1},{2},  {3},{4},{5},{6},{7},{8},{9},{10},{11},{12}

    };


    @Override
    public List<StationWrapper> getDistance(Station start, Station end) {
        return null;
    }
}
