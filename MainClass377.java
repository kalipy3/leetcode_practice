/*
 * MainClass377.java
 * Copyright (C) 2022 2022-02-15 22:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
/*
var combinationSum4 = function(nums, target) {
  nums.sort((a,b)=>b-a)
  const cache = new Map()
  function f(target){
    if(target<0) return 0
    if(target===0) return 1
    if(cache.has(target)) return cache.get(target)
    let res = 0
    for(let i=0;i<nums.length;i++){
      res += f(target-nums[i])
    }
    cache.set(target,res)
    return res
  }
  return f(target)
};

*/
