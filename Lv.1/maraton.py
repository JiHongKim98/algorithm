# 24/01/27

# 완주하지 못한 선수 문제

# - participant : 참가자
# - completion : 완주자
# - 단 한 명의 선수를 제외하고 모두 완주
#
# - 출력: 완주하지 못한 선수 출력


# hash 테이블 증/감 연산으로 풀이한 것
def solution(participant, completion):
    answer = ''
    temp = 0
    dic = {}

    for i in participant:
        dic[hash(i)] = i
        temp += int(hash(i))

    for j in completion:
        temp -= hash(j)
    answer = dic[temp]

    return answer
