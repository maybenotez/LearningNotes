package com.dark.knight.learn.project;

import java.util.List;

public interface ShortestDistance {


    /**
     * 求两个站的最短距离
     * @param start start
     * @param end end
     * @return List
     */
    List<StationWrapper> getDistance(Station start, Station end);
}
