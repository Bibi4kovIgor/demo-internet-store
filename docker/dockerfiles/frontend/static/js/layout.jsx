import React from 'react';
import Header from './Header';
import Footer from './Footer';

const Layout = ({ content }) => {
  return (
    <>
      <Header />
      {content}
      <Footer />
    </>
  );
}

export default Layout;