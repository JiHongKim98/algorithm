/*
 * 프로그래머스 - 호텔 방 배정
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/64063
 */
package Lv_4.호텔_방_배정;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Long, Long> reservation;

    public long[] solution(long k, long[] room_number) {
        reservation = new HashMap<>();

        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long curr = room_number[i];

            answer[i] = reservationRoom(curr);
        }

        return answer;
    }

    private long reservationRoom(long wantRoom) {
        if (!reservation.containsKey(wantRoom)) {
            reservation.put(wantRoom, wantRoom + 1);
            return wantRoom;
        } else {
            long newRoom = reservationRoom(reservation.get(wantRoom));
            reservation.put(wantRoom, newRoom + 1);
            return newRoom;
        }
    }
}
