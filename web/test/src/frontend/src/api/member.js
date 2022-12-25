import axios from 'axios';

const fetchMembers = async (params) => {
  return await axios.get(`http://localhost:8080/api/members`, { params });
};

export { fetchMembers };
