import React from 'react';
import Layout from './Layout';

const HomePage = () => {
  return (
    <Layout>
      <h1>Welcome to our InternetStore!</h1>
      <p>If you want to get product list, please, click on button below.</p>
      <button id="products_list">Products</button>
    </Layout>
  );
}

export default HomePage;