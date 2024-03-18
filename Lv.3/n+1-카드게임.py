# 24/01/27

# 프로그래머스 - n + 1 카드게임

# https://school.programmers.co.kr/learn/courses/30/lessons/258707

# - 카드 전체카드 수 + 1 의 값을 카드 2장의 합으로 만들어야함 (N+1 == 카드2개합)
# - 제출할 경우 해당 카드 삭제
# - 매 라운드마다 코인으로 가져올 수 있는 카드 2장이 생김 (순차적으로)
#    - 코인 한개당 카드 하나 가져올 수 있음
#
# - 출력: 최대 라운드 수


def check(hand_1, hand_2, n):
    for card in hand_1:
        check_card = (n + 1) - card

        if check_card in hand_2:  # n+1 값이 되는 카드가 있을 경우
            hand_1.remove(card)
            hand_2.remove(check_card)
            return True
    
    return False


def solution(coin, cards):
    answer = 0
    n = len(cards)  # 카드 수 + 1
    card_num = n // 3
    hand = set()  # 현재 가지고 있는 카드
    new_card = set()  # 매 라운드마다 사용될 수 있는 카드
    
    for i in range(n // 3):
        hand.add(cards[i])
    
    while card_num < n:
        for _ in range(2):  # 라운드 시작시 코인으로 사용 가능한 새로운 카드 2장 발급
            new_card.add(cards[card_num])
            card_num += 1
        
        if len(hand) >= 2 and check(hand, hand, n):  # 현재 가진 카드로만 사용한 경우
            answer += 1

        elif len(hand) >= 1 and coin >= 1 and check(hand, new_card, n):  # 코인을 1개 사용한 경우 (새 카드 1장)
            answer += 1
            coin -= 1

        elif coin >= 2 and check(new_card, new_card, n):  # 코인을 2개 사용한 경우  (새 카드 2장)
            answer += 1
            coin -= 2

        else:  # 가능한 조합이 없을 경우
            break
    
    answer = answer + 1
    return answer



solution(4, [3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4]) # 5
#solution(3, [1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12]) # 2
#solution(2, [5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7]) # 4
#solution(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]) # 1
solution(8, [1, 12, 2, 11, 3, 10, 4, 9, 5, 8, 6, 7]) # 5
