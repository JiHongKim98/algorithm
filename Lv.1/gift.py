# 24/01/26

# 가장 많이 받은 선물 문제

# - gift => (선물을 준 사람, 선물을 받은 사람)
# - 서로 선물을 주고 받지 않았다면 선물 지수가 높은 사람이 +1
# - 서로 선물을 주고 받은 개수가 같다면 선물 지수가 높은 사람이 +1
#    - 선물 지수가 같다면 +0
#
# - 출력: 가장 많이 받는 사람의 선물 수


def solution(friends: list, gifts: list):
    answer = 0
    tot_len = len(friends)
    gift_map = [[0] * len(friends) for _ in range(len(friends))]  # 선물 주고 받은 지도
    present = [0] * tot_len

    # gift_map에 선물 기록 저장
    for gift in gifts:
        _from, _to = gift.split()
        from_index = friends.index(_from)
        to_index = friends.index(_to)
        gift_map[from_index][to_index] += 1
    
    for i in range(tot_len):
        for j in range(i+1, tot_len):
            i_to_j = gift_map[i][j]  # i 가 j 에게 선물을 준 경우
            j_to_i = gift_map[j][i]  # j 가 i 에게 선물을 준 경우
            
            # 서로 선물을 주고 받은 경우
            if i_to_j != j_to_i and (i_to_j > 0 or j_to_i > 0):
                if i_to_j > j_to_i:  # i가 더 많이 준 경우
                    present[i] += 1
                else:  # j가 더 많이 준 경우
                    present[j] += 1
            
            # 서로 선물을 주고 받지 않은 경우(선물지수 계산 비교)
            else:
                i_sum = sum(gift_map[i])  # i의 선물횟수
                j_sum = sum(gift_map[j])  # j의 선물횟수

                for k in range(tot_len):
                    i_sum -= gift_map[k][i]  # i의 받은 횟수 차감
                    j_sum -= gift_map[k][j]  # j의 받은 횟수 차감

                if i_sum > j_sum:
                    present[i] += 1
                elif j_sum > i_sum:
                    present[j] += 1

    answer = max(present)
    return answer
