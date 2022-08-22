package leetcode.c871

class Solution {

    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        var tank = startFuel
        var isUse = BooleanArray(stations.size){i -> false}
        var useStationCount = 0
        while (tank < target) {
            var maxFuel = 0;
            var maxFuelIdx = 0;

            if (useStationCount == stations.size) {
                return -1
            }

            for (i in 0 until stations.size) {
                if (stations[i][0] > tank) {
                    break
                }

                if (isUse[i]) {
                    continue
                }

                if (maxFuel < stations[i][1]) {
                    maxFuel = stations[i][1]
                    maxFuelIdx = i
                }
            }

            tank += maxFuel
            isUse[maxFuelIdx] = true
            useStationCount++

        }

        return useStationCount;
    }


}

fun main() {
    var target = 100
    var startFuel = 10
    var stations:Array<IntArray> = arrayOf(
        intArrayOf(10,60),
        intArrayOf(20,30),
        intArrayOf(30,30),
        intArrayOf(60,40) )


    val minRefuelStops = Solution().minRefuelStops(target, startFuel, stations)
    println("minRefuelStops = ${minRefuelStops}")



}