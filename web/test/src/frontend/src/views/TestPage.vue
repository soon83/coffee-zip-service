<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>회원명</th>
          <th>나이</th>
          <th>성별</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="member of memberList" :key="member.memberId">
          <td>{{ member.memberName }}</td>
          <td>{{ member.memberAge }}</td>
          <td>{{ member.memberGender }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import { fetchMembers } from '@/api/member';

export default {
  data() {
    return {
      memberList: {},
    };
  },
  created() {
    this.getMembers();
  },
  methods: {
    async getMembers() {
      const fetchMembersResponse = await fetchMembers({
        memberName: '나패존',
        memberAge: 10,
        memberGender: 'MALE',
      });
      console.log('# fetchMembersResponse: ', fetchMembersResponse);

      this.memberList = fetchMembersResponse.data.data.content;
    },
  },
};
</script>
<style></style>
