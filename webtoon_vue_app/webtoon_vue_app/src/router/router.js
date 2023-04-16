import Vue from 'vue';
import VueRouter from 'vue-router';
import HomeComponent from '../components/Home';
import AboutComponent from '../components/About';


Vue.use(VueRouter);

// 라우팅 정보
// path :
const route = [
  { path: "/", component: HomeComponent, name: 'Home' },
  { path: "/about", component: AboutComponent, name: 'About'}
];

// Vue 라우터 인스턴스 생성
// history 모드는 자연스러운 url 기능, 지정하지 않으면 해시기호로 url 사용
const router = new VueRouter({
  mode: 'history',
  routes: route
});

export default router;