class Solution {
    // Explaination by chatgpt
    /*
    Sort the cars by position so that we can process them from the car closest to
    the target to the car farthest from the target.

    For each car, calculate its time to reach the target:

    (target - position) / speed

    While moving from front to back, fleetTimes.peekLast() represents the arrival
    time of the fleet immediately ahead.

    If the current car's time is less than or equal to that fleet's arrival time,
    the current car catches that fleet before or exactly at the target. It becomes
    part of the same fleet, so no new time is added.

    If the current car's time is greater than the fleet ahead's arrival time, the
    fleet ahead reaches the target before the current car can catch it. Therefore,
    the current car forms a separate fleet, and its arrival time is added.

    The first processed car always forms a fleet because fleetTimes is initially
    empty. At the end, the number of stored fleet arrival times equals the number
    of car fleets.
    */
    // Own explaination
    // Sort by position because only from the last car which is at the farthest position can be the
    // deciding factor for the cars behind it. Once the faster car behind the last car reaches the
    // last car then the faster car should match the speed of the last car, thats why we sort it by
    // position and start traversing from the last. Once that forms a fleet that becomes the last
    // fleet and the cars behind it should match the last fleet if it reaches the last fleet. To
    // calculate time to reach (target-position[i])/speed[i] and its double because the even with
    // decimal point it can vary if the car can reach the target before the car in front reaches it.
    // If the car behind can reach the target before the car in front that means it collides and
    // they form a fleet, thats the main logic of this solution. So each timeToTarget of present car
    // will be compared with fleetTimes.pollLast. if timeToTarget<=fleetTimes.pollLast that means
    // the present car can collide and it will match speed with fleetTimes.pollLast, so you dont
    // change anything in fleetTimes and move to previous car (because we are traversing from the
    // end). If timeToTarget>fleetTimes.pollLast that means by the time the present car reaches the
    // target the existing car fleet in front of the present car will reach the target, so the car
    // can never collide with car fleet and hence its a saperate fleet so you add it to the
    // fleetTimes. And at the start when we begin traversing the fleetTimes is empty so we add the
    // last car and then continue with the traversal. In the end the number of fleetTimes is
    // actually the number of car fleets, we return it.
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Deque<Double> fleetTimes = new ArrayDeque<>();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(position[a], position[b]));
        for (int i = n - 1; i >= 0; i--) {
            double timeToTarget = (double) (target - position[order[i]]) / speed[order[i]];
            if (fleetTimes.isEmpty() || timeToTarget > fleetTimes.peekLast())
                fleetTimes.offerLast(timeToTarget);
        }
        return fleetTimes.size();
    }
}