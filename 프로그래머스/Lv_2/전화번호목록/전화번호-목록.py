# 24/01/27

# 프로그래머스 - 전화번호 목록

# https://school.programmers.co.kr/learn/courses/30/lessons/42577

## - 특정 문자가 다른 문자의 접두어 일경우 False
##
## - 출력: boolean


def solution(phone_book):
    answer = True
    hash_ = {}

    for i in phone_book:  # key값 저장
        hash_[i] = 0

    for j in phone_book:
        tmp = ""
        for k in j:
            tmp += k
            if tmp in hash_ and tmp != j:  # 본인이 아니고 앞번호가 hash테이블에 있을경우
                return False

    return answer
