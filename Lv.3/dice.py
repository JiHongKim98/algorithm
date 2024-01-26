# 24/01/26

# 주사위 고르기 문제

# - 각자 n/2 개씩 가져감
# - A, B가 가져갈 수 있는 조합 생성
# - A의 모든 경우의 수의 합 > B의 모든 경우의 수의 합 구하기
#
# - 출력 : 오름차순으로 정렬


from itertools import combinations
from bisect import bisect_left


def get_sums(d):  # 주사위 눈의 가능한 모든 합을 리스트로 반환
    if len(d) == 1:
        return d[0]
    
    else:
        prev_sum = get_sums(d[:-1])

        sum_ = []
        for prev_sum in prev_sum:
            for val in d[-1]:
                sum_.append(prev_sum + val)

        return sum_


def solution(dice):
    answer = []
    tot_d = len(dice)
    dice_list = list(range(tot_d))
    max_win = 0
    
    for comb in combinations(dice_list, tot_d // 2):
        A_dice = [dice[i] for i in comb]
        B_dice = [dice[i] for i in dice_list if i not in comb]

        # A와 B 주사위의 합 배열 계산
        sum_A = get_sums(A_dice)
        sum_B = get_sums(B_dice)

        # 이진 탐색 사전 작업
        sum_A.sort()
        sum_B.sort()
        
        wins = 0
        for sA in sum_A:
            wins += bisect_left(sum_B, sA)  # sum_A의 원소보다 작은 sum_b의 개수 (이긴 횟수)
        
        # A가 이긴 횟수가 최대인 경우
        if wins >= max_win:
            max_win = wins  # 이긴 결과 갱신
            best = comb  # 승률이 가장 높은 것 저장
    
    answer = sorted([t + 1 for t in best])
    return answer
