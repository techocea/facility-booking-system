import React from "react"
import { Outlet } from "react-router-dom"
import { Navbar } from "./Navbar.tsx"

export const MainLayout: React.FC = () => {
  return (
    <div className="min-h-screen bg-sand-50">
      {/* Main View Area */}
      <div className="flex flex-1 flex-col overflow-hidden">
        <Navbar />
        {/* Content Viewport */}
        <main className="flex-1 overflow-y-auto p-4 md:p-6 lg:p-8">
          <div className="mx-auto max-w-7xl">
            <Outlet />
          </div>
        </main>
      </div>
    </div>
  )
}