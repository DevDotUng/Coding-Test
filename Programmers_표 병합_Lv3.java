import java.util.*;

class Solution {
    String[][] table = new String[51][51];
    
    public String[] solution(String[] commands) {
        
        List<List<int[]>> list = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        
        for (String c: commands) {
            String[] splitedString = c.split(" ");
            
            if (splitedString[0].equals("UPDATE") && splitedString.length == 4) {
                update(Integer.parseInt(splitedString[1]), Integer.parseInt(splitedString[2]), splitedString[3], list);
            } else if (splitedString[0].equals("UPDATE") && splitedString.length == 3) {
                update(splitedString[1], splitedString[2]);
            } else if (splitedString[0].equals("MERGE")) {
                merge(Integer.parseInt(splitedString[1]), Integer.parseInt(splitedString[2]), Integer.parseInt(splitedString[3]), Integer.parseInt(splitedString[4]), list);
            } else if (splitedString[0].equals("UNMERGE")) {
                unmerge(Integer.parseInt(splitedString[1]), Integer.parseInt(splitedString[2]), list);
            } else {
                print(Integer.parseInt(splitedString[1]), Integer.parseInt(splitedString[2]), list, answerList);
            }
        }
        
        String[] answer = new String[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    void update(int r, int c, String value, List<List<int[]>> list) {
        List<int[]> mergedList = getMergedList(r, c, list);
        if (mergedList == null) {
            table[r][c] = value;
        } else {
            for (int[] merged: mergedList) {
                table[merged[0]][merged[1]] = value;
            }
        }
    }
    
    void update(String value1, String value2) {
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[1].length; j++) {
                if (table[i][j] != null && table[i][j].equals(value1)) {
                    table[i][j] = value2;
                }
            }
        }
    }
    
    void merge(int r1, int c1, int r2, int c2, List<List<int[]>> list) {
        if (r1 == r2 && c1 == c2) return;
        
        List<int[]> mergedList1 = getMergedList(r1, c1, list);
        List<int[]> mergedList2 = getMergedList(r2, c2, list);
        
        if (mergedList1 == null && mergedList2 == null) {
            if (table[r1][c1] != null && table[r2][c2] == null) {
                table[r2][c2] = table[r1][c1];
            } else if (table[r1][c1] == null && table[r2][c2] != null) {
                table[r1][c1] = table[r2][c2];
            } else if (table[r1][c1] != null && table[r2][c2] != null) {
                table[r2][c2] = table[r1][c1];
            }
            
            List<int[]> listTmp = new ArrayList<>();
            listTmp.add(new int[]{r1, c1});
            listTmp.add(new int[]{r2, c2});
            
            list.add(listTmp);
            
        } else if (mergedList1 != null && mergedList2 == null) {
            int mergedListIndex = getMergedListIndex(r1, c1, list);
            list.get(mergedListIndex).add(new int[]{r2, c2});
            
            if (table[r1][c1] != null && table[r2][c2] == null) {
                for (int[] e: list.get(mergedListIndex)) {
                    table[e[0]][e[1]] = table[r1][c1];
                }
            } else if (table[r1][c1] == null && table[r2][c2] != null) {
                for (int[] e: list.get(mergedListIndex)) {
                    table[e[0]][e[1]] = table[r2][c2];
                }
            } else if (table[r1][c1] != null && table[r2][c2] != null) {
                for (int[] e: list.get(mergedListIndex)) {
                    table[e[0]][e[1]] = table[r1][c1];
                }
            }
            
        } else if (mergedList1 == null && mergedList2 != null) {
            int mergedListIndex = getMergedListIndex(r2, c2, list);
            list.get(mergedListIndex).add(new int[]{r1, c1});
            
            if (table[r1][c1] != null && table[r2][c2] == null) {
                for (int[] e: list.get(mergedListIndex)) {
                    table[e[0]][e[1]] = table[r1][c1];
                }
            } else if (table[r1][c1] == null && table[r2][c2] != null) {
                for (int[] e: list.get(mergedListIndex)) {
                    table[e[0]][e[1]] = table[r2][c2];
                }
            } else if (table[r1][c1] != null && table[r2][c2] != null) {
                for (int[] e: list.get(mergedListIndex)) {
                    table[e[0]][e[1]] = table[r1][c1];
                }
            }
            
        } else {
            int mergedListIndex1 = getMergedListIndex(r1, c1, list);
            int mergedListIndex2 = getMergedListIndex(r2, c2, list);
            
            if (mergedListIndex1 != mergedListIndex2) {
                for (int[] e: mergedList2) {
                    list.get(mergedListIndex1).add(new int[]{e[0], e[1]});
                }
                list.remove(mergedListIndex2);
                
                mergedListIndex1 = getMergedListIndex(r1, c1, list);

                if (table[r1][c1] != null && table[r2][c2] == null) {
                    for (int[] e: list.get(mergedListIndex1)) {
                        table[e[0]][e[1]] = table[r1][c1];
                    }
                } else if (table[r1][c1] == null && table[r2][c2] != null) {
                    for (int[] e: list.get(mergedListIndex1)) {
                        table[e[0]][e[1]] = table[r2][c2];
                    }
                } else if (table[r1][c1] != null && table[r2][c2] != null) {
                    for (int[] e: list.get(mergedListIndex1)) {
                        table[e[0]][e[1]] = table[r1][c1];
                    }
                }
            }
        }
    }
    
    void unmerge(int r, int c, List<List<int[]>> list) {
        if (getMergedList(r, c, list) == null) return;
        
        int mergedListIndex = getMergedListIndex(r, c, list);
        List<int[]> mergedList = getMergedList(r, c, list);
        String value = table[r][c] == null ? null : table[r][c];
        
        for (int[] e: list.get(mergedListIndex)) {
            table[e[0]][e[1]] = null;
        }
        list.remove(mergedListIndex);
        table[r][c] = value;
    }
    
    void print(int r, int c, List<List<int[]>> list, List<String> answerList) {
        if (table[r][c] == null) {
            answerList.add("EMPTY");
        } else {
            answerList.add(table[r][c]);
        }
    }
    
    List<int[]> getMergedList(int r, int c, List<List<int[]>> list) {
        for (List<int[]> list2: list) {
            for (int[] arr: list2) {
                if (arr[0] == r && arr[1] == c) {
                    return list2;
                }
            }
        }
        return null;
    }
    
    int getMergedListIndex(int r, int c, List<List<int[]>> list) {
        int index = 0;
        
        for (List<int[]> list2: list) {
            for (int[] arr: list2) {
                if (arr[0] == r && arr[1] == c) {
                    return index;
                }
            }
            index++;
        }
        
        return -1;
    }
}