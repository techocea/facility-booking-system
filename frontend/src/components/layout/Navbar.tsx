import React from "react"
import { BuildingIcon, CalendarIcon } from "@phosphor-icons/react"
import { Button } from "@/components/ui/button.tsx"

export const Navbar: React.FC = () => {
  return (
    <header className="sticky top-0 z-40 bg-sand-50/85 backdrop-blur-md border-b border-sand-200">
      <div className="max-w-6xl mx-auto px-5 sm:px-6">
        <div className="flex items-center justify-between h-16">
          <div className="flex items-center gap-2.5">
            <BuildingIcon className="w-5 h-5 text-sand-700" strokeWidth={1.5} />
            <span className="font-serif text-xl font-medium text-sand-900 tracking-tight">FacilityHub</span>
          </div>
          <div className="flex items-center gap-2">
            <Button variant="outline">
              <a href="/admin"
                 className="flex items-center gap-2 px-3 py-2 text-sm font-medium text-sand-500 hover:text-sand-900 transition-colors"
              >
                Admin
              </a>
            </Button>
            <Button
            >
              <CalendarIcon className="w-4 h-4" strokeWidth={1.5} />
              <span className="hidden sm:inline">My Bookings</span>
            </Button>
          </div>
        </div>
      </div>
    </header>
  )
}