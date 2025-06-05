// src/layout/MainLayout.jsx
import React from "react";
import LargeNav from "../assets/components/Header/LargeNav";
import { Outlet } from "react-router-dom";

const MainLayout = () => {
  return (
    <div className="flex">
      <aside className="w-64 bg-gray-900 text-white min-h-screen p-4">
        <LargeNav />
      </aside>
      <main className="flex-1 bg-gray-950 text-white p-4">
        <Outlet />
      </main>
    </div>
  );
};

export default MainLayout;