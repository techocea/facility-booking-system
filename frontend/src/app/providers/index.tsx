import React from "react"
import { QueryClientProvider } from "@tanstack/react-query"
import { queryClient } from "@/lib/react-query.ts"
import { QueryProvider } from "@/app/providers/QueryProvider.tsx"

interface AppProviderProps {
  children: React.ReactNode;
}

export const AppProvider: React.FC<AppProviderProps> = ({ children }) => {
  return (
    <QueryClientProvider client={queryClient}>
      <QueryProvider>
        {children}
      </QueryProvider>
    </QueryClientProvider>
  )
}