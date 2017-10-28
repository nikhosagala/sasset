import {NbMenuItem} from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Dashboard',
    icon: 'nb-home',
    link: '/pages/dashboard',
    home: true,
  },
  {
    title: 'MENU',
    group: true,
  },
  {
    title: 'Assets',
    icon: 'nb-compose',
    link: '/pages/assets',
    children: [
      {
        title: 'AC',
        link: '/pages/assests/AC',
      },
      {
        title: 'Genset',
        link: '/pages/assets/Genset',
      },
    ],
  },
  {
    title: 'Reports',
    icon: 'nb-bar-chart',
    link: '/pages/reports',
  },
];
