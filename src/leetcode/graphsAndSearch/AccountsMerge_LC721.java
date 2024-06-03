package leetcode.graphsAndSearch;

import leetcode.twoPointers.StreamApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountsMerge_LC721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);

        Map<String, Integer> emailToId = createEmailToId(accounts, uf);

        // prepare a hash with index in accounts as key and list of unique email address for that account as value
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(String key : emailToId.keySet()) {
            int parent = uf.find(emailToId.get(key));
            idToEmails.putIfAbsent(parent, new ArrayList<String>());
            idToEmails.get(parent).add(key);
        }

        // collect the emails from idToEmails, sort it and add account name at index 0 to get the final list to add to final return List
        List<List<String>> result =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails =  idToEmails.get(id);
            Collections.sort(emails);

            List<String> currentRes = new ArrayList();
            currentRes.add(accounts.get(id).get(0));
            currentRes.addAll(emails);
            result.add(currentRes);
        }

        return result;
    }

    private Map<String, Integer> createEmailToId(List<List<String>> accounts, UnionFind uf) {
        HashMap<String, Integer> emailToId = new HashMap<>();

        int id = 0;
        for(List<String> account: accounts) {
            for(int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                if (emailToId.containsKey(email)) {
                    uf.union(id, emailToId.get(email));
                } else  {
                    emailToId.put(email, id);
                }
            }
            id++;
        }
        return emailToId;
    }

    private static class UnionFind {
        int[] parent;

        public UnionFind(int num) {
            parent = new int[num];

            for(int i =  0; i < num; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int  b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }
            parent[rootB] = rootA;
        }

        public int find(int index) {
            if (parent[index] == index) {
                return index;
            }

            parent[index] = find(parent[index]);
            return parent[index];
        }
    }
}
