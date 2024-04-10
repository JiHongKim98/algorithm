/*
 * 24/03/21
 *
 * 프로그래머스 - 신고 결과 받기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
package 신고결과받기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 내 풀이
class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		Map<String, Integer> idMap = new HashMap<>();
		Map<String, List<String>> reportMap = new HashMap<>();

		// init idMap, reportMap
		for (int i = 0; i < id_list.length; i++) {
			idMap.put(id_list[i], i);
			reportMap.put(id_list[i], new ArrayList<>());
		}

		for (String temp : report) {
			String[] split = temp.split(" ");

			if (!reportMap.get(split[1]).contains(split[0])) {
				reportMap.get(split[1]).add(split[0]);  // <신고 대상, 신고자>
			}
		}

		for (String id : reportMap.keySet()) {
			if (reportMap.get(id).size() >= k) {  // 신고를 k 번 이상 받을 경우

				for (String _id : reportMap.get(id)) {
					int indexNum = idMap.get(_id);
					answer[indexNum] += 1;
				}
			}
		}

		return answer;
	}
}

// 다른 사람 풀이
// import java.util.*;
//
// class Solution_Other {
//     public int[] solution(String[] id_list, String[] report, int k) {
//         int[] answer = new int[id_list.length];
//         ArrayList<User> users = new ArrayList<>();
//         HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
//         HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
//         int idx = 0;
//
//         for(String name : id_list) {
//             idIdx.put(name,idx++);
//             users.add(new User(name));
//         }
//
//         for(String re : report){
//             String[] str = re.split(" ");
//             users.get( idIdx.get(str[0])).reportList.add(str[1]);
//             users.get( idIdx.get(str[1])).reportedList.add(str[0]);
//         }
//
//         for(User user : users){
//             if(user.reportedList.size() >= k)
//                 suspendedList.put(user.name,1);
//         }
//
//          for(User user : users){
//              for(String nameReport : user.reportList){
//                  if(suspendedList.get(nameReport) != null){
//                      answer[idIdx.get(user.name)]++;
//                  }
//
//              }
//         }
//
//         return answer;
//     }
// }
//
// class User{
//     String name;
//     HashSet<String> reportList;
//     HashSet<String> reportedList;
//
//     public User(String name){
//         this.name = name;
//         reportList = new HashSet<>();
//         reportedList = new HashSet<>();
//     }
// }
