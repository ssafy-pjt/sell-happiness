<script setup>

const onPayment = () => {
  /* 1. 가맹점 식별하기 */
  const { IMP } = window
  IMP.init('imp17710066')

  console.log("@@@", IMP)

  /* 2. 결제 데이터 정의하기 */
  const data = {
    pg: 'html5_inicis',                           // PG사
    pay_method: 'card',                           // 결제수단
    merchant_uid: `merchant_${new Date().getTime()}`,           // 주문번호
    amount: 100,                                 // 결제금액
    name: '아임포트 결제 데이터 분석',                  // 주문명
    buyer_name: '김동훈',                           // 구매자 이름
    buyer_tel: '01063943886',                     // 구매자 전화번호
    buyer_email: 'huni19541@gmail.com',               // 구매자 이메일
    buyer_addr: '신사동 661-16',                    // 구매자 주소
    buyer_postcode: '06018',                      // 구매자 우편번호
  }

  /* 4. 결제 창 호출하기 */
  IMP.request_pay(data,
      function (rsp) {
        // callback
        //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
        if(rsp.success) {
          console.log("결제 성공", rsp)

          // 결제 검증


        } else {
          console.log("결제 실패", rsp)
        }
      }
  )
}
</script>

<template>
  <h1>-------------------</h1>
  <button @click="onPayment">
    결제하기
  </button>
</template>

<style scoped>

</style>