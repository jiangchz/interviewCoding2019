package leetcode.graphsAndSearch;

import java.util.*;

/**
 * Eulerian Path/Circuit algorithm (Hierholzer's algorithm) | Graph Theory
 * https://www.youtube.com/watch?v=8MpoO2zA2l4
 *  time O(ELogE) E means number of edges
 *
 */
public class ReconstructItinerary_LC332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> route = new LinkedList();
        Map<String, PriorityQueue<String>> targets = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            targets.computeIfAbsent(from, ignore -> new PriorityQueue()).add(to);
        }

        dfs("JFK", targets, route);
        return route;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> targets, List<String> route) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            dfs(targets.get(airport).poll(), targets, route);
        }

        route.add(0, airport);
    }

}


/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 *
 * Example 1:
 *
 *
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * Example 2:
 *
 *
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order
 */