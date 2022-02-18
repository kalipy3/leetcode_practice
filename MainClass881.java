/*
 * MainClass881.java
 * Copyright (C) 2022 2022-02-16 12:58 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }
}


//kalipy一次过
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] > limit) {
                --heavy;
                ++ans;
            } else if (people[light] + people[heavy] <= limit) {
                light++;
                heavy--;
                ans++;
            }

        }
        return ans;
    }
}

//5
//3 3 4 5

//3
//1 1 1 3
