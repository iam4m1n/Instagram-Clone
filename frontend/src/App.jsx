// src/App.jsx

import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home/Home";
import MainLayout from "./layout/MainLayout";

const App = () => {
  return (
    <MainLayout>
      <Routes>
        <Route path="/" element={<MainLayout />} />
        <Route index element={<Home />} />
        <Route path="search" element={<Search />} />
      </Routes>
    </MainLayout>
  );
};

export default App;
